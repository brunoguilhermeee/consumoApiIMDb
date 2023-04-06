import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    /**
     * @throws IOException
     */
    public void cria(InputStream inputStream, String nomeArquivo) throws IOException {

       // InputStream InputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();

        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, null, 0, 0);

        graphics.drawString("TOPZERA", 100, novaAltura - 100);

         // configurar a fonte
         var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
         graphics.setColor(Color.YELLOW);
         graphics.setFont(fonte);


        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

        System.out.println();

 
    }

}
