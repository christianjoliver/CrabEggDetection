package processamento;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * @author Christian Oliveira
 */

public class ProcessamentoImagem {

	public static BufferedImage riRedSmolka(BufferedImage imagem) {
		double max = -Double.MAX_VALUE;
		double min = Double.MAX_VALUE;
		double ri;

		for(int i = 0; i < imagem.getWidth(); i++) {
                    for(int j = 0; j < imagem.getHeight(); j++) {
                        Color c = new Color(imagem.getRGB(i, j));
                        double r = new Double(c.getRed());
                        double g = new Double(c.getGreen());
                        double b = new Double(c.getBlue());
                        
                        if(r!=0){     
                            ri = (double)(Math.pow((r - Math.max(g, b)), 2)) / r;
                            if (ri < min) min = ri;
                            if (ri > max) max = ri;
                        }
                    }
		}
		
		for(int i = 0; i < imagem.getWidth(); i++) {
                    for(int j = 0; j < imagem.getHeight(); j++) {
                        Color c = new Color(imagem.getRGB(i, j));
                        double r = new Double(c.getRed());
                        double g = new Double(c.getGreen());
                        double b = new Double(c.getBlue());

                        if(r==0){
                            Color novo = new Color(0, 0, 0);
                            imagem.setRGB(i, j, novo.getRGB());
                        }
                        else{
                            ri = (double)(Math.pow((r - Math.max(g, b)), 2)) / r;

                            double riNormalizado = 255 * ((ri - min) / (max - min));
                            int riBW = (int) riNormalizado;

                            Color novo = new Color(riBW, riBW, riBW);
                            imagem.setRGB(i, j, novo.getRGB());
                        }
                    }
		}
		return imagem;
	}
                    /*
					// Calculo opcional para Normalização,
					// por se encaixar melhor em determinadas ocasiões

                    ri =  ri * 255;
					
                    if((ri) < 0){
					   Color newColor = new Color(0, 0, 0);
					   imagem.setRGB(i, j, newColor.getRGB());
					} else if(ri > 255){
					   Color newColor = new Color((int)(ri), (int)(ri), (int)(ri));
					   imagem.setRGB(i, j, newColor.getRGB());
					} else {
					   Color newColor = new Color((int) ri, (int) ri, (int) ri);
					   imagem.setRGB(i, j, newColor.getRGB());
					}
                    */
					
	
	public static BufferedImage OtsuBinarization(BufferedImage img) {
		
		BufferedImage res = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
		// ROTINA de de Otsu TRADICIONAL

		//Armazenando o tamanho da imagem
		int Largura = img.getWidth();// Largura da imagem
		int Altura = img.getHeight();// Altura da imagem
		int col, lin, i, cinza;
		double totalPixel= (double) Largura * Altura;
		double [] proba = new double[256];
		int [] histogram = new int[256];
		int k, uiLimiar;
			   
		// inicializacao do Histograma
		for(i=0; i < 256; i++){
			histogram[i]= 0;
		}

		// calculo do Histograma  
		for( lin = 0; lin < Altura; lin++) {
			for( col = 0; col < Largura; col++) {
				Color x = new Color(img.getRGB(col,lin));
				cinza = (int)((x.getGreen() + x.getRed() + x.getBlue())/3);
				histogram[cinza]++;
			}
		}
			
		// Aloca as Matrizes
		double fSigmaBMax, fMiTotal;
		double [] fOmega = new double[256], fMi = new double[256] , fSigmaB = new double[256];

		//Passo 2: Calculo de probabilidades
		for (i = 0; i < 256; i++) {
			proba[i] = (double) ((histogram[i])/(double)(totalPixel));
			fOmega[i] = fMi[i] = 0.0;
		}

		for (k = 0; k < 256; k++){
			for (i = 0; i < k; i++){
				fOmega[k] += proba[i];
			}
		}

		for (k = 0; k < 256; k++){
			for (i = 0; i < k; i++){
				fMi[k] += (i + 1) * proba[i];
			}
		}
	  
		fMiTotal = fSigmaBMax = 0.0;  
		uiLimiar = 128; //inicialização do valor de limiar  de Otsu

		for (i = 0; i < 256; i++){
			fMiTotal += (i + 1) * proba[i];
		}

		if ((fOmega[0] * (1 - fOmega[0])) != 0.0){
			fSigmaBMax = (  (fMiTotal * fOmega[0] - fMi[0]) * (fMiTotal * fOmega[0] - fMi[0]) ) / (fOmega[0] * (1 - fOmega[0]));
			uiLimiar = 0;
		}

		for (k = 1; k < 256; k++){
			if ((fOmega[k] * (1 - fOmega[k])) != 0.0){
			   fSigmaB[k] = (  (fMiTotal * fOmega[k] - fMi[k]) * (fMiTotal * fOmega[k] - fMi[k]) ) / (fOmega[k] * (1 - fOmega[k]));

				if (fSigmaB[k] > fSigmaBMax){
					fSigmaBMax = fSigmaB[k];
					uiLimiar = ( int) k;
				}
			}
		}
		
		// valor de limiar  de Otsu modificado para poder pegar toda a regiao da mama 
		System.out.println(uiLimiar);
		
		//Cria a  imagem  binarizada 
		// Aloca a Matriz
		int [][] pBufferbinario = new int[Altura][Largura]; //Cria um PONTEIRO para a  imagem  binarizada 

		for( lin = 0; lin < Altura; lin++) {
			for( col = 0; col < Largura; col++) {
			Color x = new Color(img.getRGB(col,lin));
				cinza = (int)((x.getGreen() + x.getRed() + x.getBlue())/3); 
				if (cinza >= uiLimiar){
					pBufferbinario[lin][col] = 1;
				} else {
					//255; mudado para fazer a multiplicacao img original * binária
					pBufferbinario[lin][col] = 0;
				}
			}
		}

		//Aqui Gera a  imagem binária 
		for( lin = 0; lin < Altura; lin++) {
			for( col = 0; col < Largura; col++){
				int atual = pBufferbinario[lin][col]* 255;
				Color novo = new Color(atual, atual, atual);
				res.setRGB(col,lin, novo.getRGB());
			}
		}
		return res;
	}
        
                
        public static BufferedImage RenyiBinarization(BufferedImage img) {
		
		BufferedImage res = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
		// ROTINA de de Otsu TRADICIONAL

		//Armazenando o tamanho da imagem
		int Largura = img.getWidth();// Largura da imagem
		int Altura = img.getHeight();// Altura da imagem
		int col, lin, cinza, j;
		double totalPixel= (double) Largura * Altura;
		int [] histogram = new int[256];
                int Limiar;
                long t, i;
                double [] prob = new double[256];
                double ha1,ha2,Alfa;
                double soma1,soma2;
                double total1,total2;
                double ha,ham1,ham2,ham3;
                double w,p1,p3;
                double b1=0,b2=0,b3=0;
                byte Limiar1=0,Limiar2=0,Limiar3=0;
                byte LimiarAux;
 
                
                // inicializacao do Histograma
		for(j=0; j < 256; j++){
			histogram[j] = 0;
		}

		// calculo do Histograma  
		for( lin = 0; lin < Altura; lin++) {
			for( col = 0; col < Largura; col++) {
				Color x = new Color(img.getRGB(col,lin));
				cinza = (int)((x.getGreen() + x.getRed() + x.getBlue())/3);
				histogram[cinza]++;
			}
		}
                
                // calculo da probabilidade
                for (j = 0; j < 256; j++) {
			prob[j] = (double) ((histogram[j])/(double)(totalPixel));
		}
                
                
                // pre calculo do limiar
                ham1=0;
                ham2=0;
                ham3=0;
                
                for(t = 0; t < 255; t++)
                {       
                        total1 = 0;
                        for (i=  0; i <= t; i++)
                                total1 += prob[(int)i];
                        total2 = 0;
                        
                        for (i = t+1; i < 256; i++){
                                total2 += prob[(int)i];
                        }
  
                        if ( (total1 == 0) || (total2 == 0) )
                                continue;
                        
                        // Calculo de t* para 0 < Alfa < 1
                        for(Alfa=0.1;Alfa<=0.9;Alfa+=0.1)
                        {
                                soma1 = 0;
                                for(j = 0; j<= t;j++)
                                        soma1 += Math.pow(prob[j]/total1, Alfa);
                                
                                ha1 = (1/(1 - Alfa)) * Math.log(soma1);

                                soma2 = 0;
                                for(i = t+1; i < 256; i++)
                                        soma2 += Math.pow(prob[(int)i]/total2, Alfa);
                                
                                ha2 = (1/(1 - Alfa)) * Math.log(soma2);

                                ha = ha1 + ha2;

                                if (ha > ham1)
                                {
                                        ham1	= ha;
                                        Limiar1	= (byte)t;
                                }
                        }
                        
                        // Calculo de t* para Alfa -> 1
                        for(Alfa=0.9995;Alfa<=1.0005;Alfa+=0.0002)
                        {
                                soma1 = 0;
                                for(j = 0;j <= t; j++)
                                        soma1 += Math.pow(prob[j]/total1,Alfa);
                                ha1 = (1/(1 - Alfa))* Math.log(soma1);

                                soma2 = 0;
                                for(i = t+1;i< 256; i++)
                                        soma2 += Math.pow(prob[(int)i]/total2,Alfa);
                                ha2 = (1/(1 - Alfa))*Math.log(soma2);

                                ha = ha1 + ha2;

                                if (ha > ham2)
                                {
                                        ham2	= ha;
                                        Limiar2	= (byte)t;
                                }
                        }
                        
                        // Calculo de t* para 1 < Alfa < oo
                        for(Alfa=5; Alfa < 100; Alfa+=10)
                        {
                                soma1 = 0;
                                for(i = 0; i <= t; i++)
                                        soma1 += Math.pow(prob[(int)i]/total1,Alfa);
                                ha1 = (1/(1 - Alfa))*Math.log(soma1);

                                soma2 = 0;
                                for(i = t+1; i < 256; i++)
                                        soma2 += Math.pow(prob[(int)i]/total2,Alfa);
                                ha2 = (1/(1 - Alfa))*Math.log(soma2);

                                ha = ha1 + ha2;

                                if (ha > ham3)
                                {
                                        ham3	= ha;
                                        Limiar3	= (byte)t;
                                }
                        }
                }
                
                // Ordenacao dos Limiarires
                if ( (Limiar1 > Limiar2) )
                {
                        LimiarAux	= Limiar2;
                        Limiar2		= Limiar1;
                        Limiar1		= LimiarAux;
                }

                if ( (Limiar1 > Limiar3) )
                {
                        LimiarAux	= Limiar3;
                        Limiar3		= Limiar1;
                        Limiar1		= LimiarAux;
                }

                if ( (Limiar2 > Limiar3) )
                {
                        LimiarAux	= Limiar3;
                        Limiar3		= Limiar2;
                        Limiar2		= LimiarAux;
                }

                // Calculo do Parametros para calcular tc
                p1=0;
                for(i=0;i<=Limiar1;i++)
                        p1 += prob[(int)i];

                p3=0;
                for(i=0; i<=Limiar3; i++)
                        p3 += prob[(int)i];

                w = p3 - p1;

                if ( ((Limiar2-Limiar1) <= 5) && ((Limiar3-Limiar2) <= 5) )
                {
                        b1=1;b2=2;b3=1;
                }

                if ( ((Limiar2-Limiar1) >  5) && ((Limiar3-Limiar2) >  5) )
                {
                        b1=1;b2=2;b3=1;
                }

                if ( ((Limiar2-Limiar1) <= 5) && ((Limiar3-Limiar2) >  5) )
                {
                        b1=0;b2=1;b3=3;
                }

                if ( ((Limiar2-Limiar1) >  5) && ((Limiar3-Limiar2) <= 5) )
                {
                        b1=3;b2=1;b3=0;
                }

                // Calculo do Limiar tc
                Limiar	= (int)(Limiar1*(p1+(0.25*w*b1)) + (0.25*Limiar2*w*b2) + Limiar3*(1-p3+(0.25*w*b3)));
                
               //#########################################################################
                
                //Cria a  imagem  binarizada 
		// Aloca a Matriz
                
		int [][] pBufferbinario = new int[Altura][Largura]; //Cria um PONTEIRO para a  imagem  binarizada 

		for( lin = 0; lin < Altura; lin++) {
			for( col = 0; col < Largura; col++) {
			Color x = new Color(img.getRGB(col,lin));
				cinza = (int)((x.getGreen() + x.getRed() + x.getBlue())/3); 
				if (cinza >= Limiar){
					pBufferbinario[lin][col] = 1;
				} else {
					//255; mudado para fazer a multiplicacao img original * binária
					pBufferbinario[lin][col] = 0;
				}
			}
		}

		//Aqui Gera a  imagem binária 
		for( lin = 0; lin < Altura; lin++) {
			for( col = 0; col < Largura; col++){
				int atual = pBufferbinario[lin][col]* 255;
				Color novo = new Color(atual, atual, atual);
				res.setRGB(col,lin, novo.getRGB());
			}
		}
		return res;
	}
        
        public static double[] RGBtoLab(BufferedImage img, int image_x, int image_y){ 

            // exemplo de alocacao de vetor contendo as variáveis do espaço de cor Lab
            double[] pSaida = new double[3]; //Cria um PONTEIRO para armazenar cálculos

            Color orig = new Color(img.getRGB(image_x, image_y));  // lendo o valor RGB do pixel(i,j)

            // Conventendo RGB para sRGB - normalizando entre 0 e 1 
            // convert 0..255 into 0..1 
            double r = orig.getRed() / 255.0; 
            double g = orig.getGreen() /255.0;
            double b = orig.getBlue() / 255.0; 

            // Usando sRGB 
            if (r <= 0.04045)  r = r / 12.92; 
            else  r = Math.pow(((r + 0.055) / 1.055), 2.4); 

            if (g <= 0.04045) 	   g = g / 12.92; 
            else 	   g = Math.pow(((g + 0.055) / 1.055), 2.4); 

            if (b <= 0.04045) 	   b = b / 12.92; 
            else   b = Math.pow(((b + 0.055) / 1.055), 2.4); 

            r *= 100.0; // normalizando entre 0 e 100
            g *= 100.0; // normalizando entre 0 e 100
            b *= 100.0; // normalizando entre 0 e 100

            //Conversão de sRGB para Espaço de cor XYZ
            double Xx = r * 0.412424 + g * 0.357579 + b * 0.180464;
            double Yx = r * 0.212656 + g * 0.715158 + b * 0.0721856;
            double Zx = r * 0.0193324 + g * 0.119193 + b * 0.950444;

            //Conversão de XYZ para L* a* b* CORRIGIDO usando sRGB antes 
            // Usando Observer. = 2°, Illuminant = D65
            // D65 = {95.047, 100.000, 108.883};
            double x = Xx / 95.047; 
            double y = Yx / 100; 
            double z = Zx / 108.883; 

            if (x > 0.008856)    	x = Math.pow(x, 1.0/3.0);  
            else 	   				x = (7.787 * x) + (16.0/116.0); 

            if (y > 0.008856) 	  	y = Math.pow(y, 1.0/3.0); 
            else 				  	y = (7.787 * y) + (16.0/116.0); 

            if (z > 0.008856) 	   z = Math.pow(z, 1.0/3.0); 
            else 				   z = (7.787 * z) + (16.0/116.0);  

            double L = (116.0 * y) - 16.0; 
            double a = 500.0 * (x - y); 
            double b_lab = 200.0 * (y - z); 

            //O retorno de cada indice do espaço de cores Lab para cada pixel da imagem dada
            pSaida[0] = L; 
            pSaida[1] = a; 
            pSaida[2] = b_lab; 

            return pSaida;
    }
        
    // Código de conversão de RGB para CMY
    public static double[] RGBtoCMY(BufferedImage img, int image_x, int image_y){ 

        // exemplo de alocacao de vetor contendo as variáveis do espaço de cor CMY
        double[] pSaida = new double[3]; //Cria um PONTEIRO para armazenar cálculos
        
        Color orig = new Color(img.getRGB(image_x, image_y));  // lendo o valor RGB do pixel(i,j)
				
	// Conventendo RGB para CMY - normalizando entre 0 e 1 
	// convert 0..255 into 0..1 
	double c = 1 - (orig.getRed() / 255.0); //Ciano
        double m = 1 - (orig.getGreen() /255.0); //Magenta
	double y = 1 - (orig.getBlue() / 255.0); //Amarelo
                
	//O retorno de cada indice do espaço de cores CMY para cada pixel da imagem dada
        pSaida[0] = c; 
        pSaida[1] = m; 
        pSaida[2] = y; 
        
        return pSaida;
    }
    
    public static double[] RGBtoXYZ(BufferedImage img, int image_x, int image_y){ 

        // exemplo de alocacao de vetor contendo as variáveis do espaço de cor Lab
        double[] pSaida = new double[3]; //Cria um PONTEIRO para armazenar cálculos
        
        Color orig = new Color(img.getRGB(image_x, image_y));  // lendo o valor RGB do pixel(i,j)
				
	// Conventendo RGB para sRGB - normalizando entre 0 e 1 
	// convert 0..255 into 0..1 
	double r = orig.getRed() / 255.0; 
        double g = orig.getGreen() /255.0;
	double b = orig.getBlue() / 255.0; 

	// Usando sRGB 
	if (r <= 0.04045)  r = r / 12.92; 
	else  r = Math.pow(((r + 0.055) / 1.055), 2.4); 
			
	if (g <= 0.04045) 	   g = g / 12.92; 
	else 	   g = Math.pow(((g + 0.055) / 1.055), 2.4); 

	if (b <= 0.04045) 	   b = b / 12.92; 
	else   b = Math.pow(((b + 0.055) / 1.055), 2.4); 

	r *= 100.0; // normalizando entre 0 e 100
        g *= 100.0; // normalizando entre 0 e 100
	b *= 100.0; // normalizando entre 0 e 100

        //Conversão de sRGB para Espaço de cor XYZ
        double x = r * 0.412424 + g * 0.357579 + b * 0.180464;
        double y = r * 0.212656 + g * 0.715158 + b * 0.0721856;
        double z = r * 0.0193324 + g * 0.119193 + b * 0.950444;

        
        pSaida[0] = x; 
        pSaida[1] = y; 
        pSaida[2] = z;
        
        return pSaida;
    }
    
    
}
