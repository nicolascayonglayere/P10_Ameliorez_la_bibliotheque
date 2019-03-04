package oc.webApp.nicolas.actions.images;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Classe Action concernant les images
 * 
 * @author nicolas
 *
 */
@Service
public class ImageAction extends ActionSupport {

	static final Logger logger = LogManager.getLogger();
	private static final long serialVersionUID = 1L;
	byte[] imageInByte = null;
	String imageId;
	private String cheminImg;

	/**
	 * Constructeur sans paramètre
	 */
	public ImageAction() {
		logger.debug("constructeur ImageAction");
	}

	@Override
	public String execute() {
		return SUCCESS;
	}

	/**
	 * Méthode pour convertir le fichier image en tableau de byte
	 * 
	 * @return un tableau de byte correspondant a l'image
	 */
	public byte[] getCustomImageInBytes() {
		logger.debug("imageId " + this.imageId);
		System.out.println("imageId " + this.imageId);
		BufferedImage originalImage;
		try {
			InputStream is = new FileInputStream(this.getImageFile(this.imageId));
			originalImage = ImageIO.read(is);
			// convert BufferedImage to byte array
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "JPG", baos);
			baos.flush();
			this.imageInByte = baos.toByteArray();
			baos.close();
		} catch (IOException e) {
			logger.debug(e.getMessage());
			// e.printStackTrace();
		}
		logger.debug("trace " + this.imageInByte.toString());
		return this.imageInByte;
	}

	/**
	 * Méthode pour récupérer le fichier image
	 * 
	 * @param imageId
	 * @return le fichier contenant l'image
	 */
	private File getImageFile(String imageId) {
		System.out.println("chemin : " + this.cheminImg);
		File file = new File(this.cheminImg, imageId + ".jpg");
		logger.debug(file.toString());
		System.out.println(file.toString());
		return file;
	}

	// --Getter et setter--
	public String getCustomContentType() {
		return "image/JPG";
	}

	public String getCustomContentDisposition() {
		return "anyname.JPG";
	}

	public String getImageId() {
		return this.imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getCheminImg() {
		return this.cheminImg;
	}

	@Value("${chemin.image}")
	public void setCheminImg(String cheminImg) {
		this.cheminImg = cheminImg;
	}

}
