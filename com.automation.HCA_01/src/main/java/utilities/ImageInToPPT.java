package utilities;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

import org.apache.poi.util.IOUtils;
import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

public class ImageInToPPT {

	public static XSLFSlide slide;
	/*public static String screenShotPath = "D:\\TestScreenShot\\Image";
	public static String outPutPPTPath = "D:\\TestScreenShot\\ppt\\Presentation.pptx";*/
	
	public static void main(String args[]) throws IOException {

		//ImageInToPPT image = new ImageInToPPT();
		//image.addImageInToSlide();
		
	}
	
	public void setTextInTitle(String imgDesc) {

		XSLFTextShape textShape = slide.getPlaceholder(0);
		textShape.clearText();
		XSLFTextParagraph p = textShape.addNewTextParagraph();
		XSLFTextRun r1 = p.addNewTextRun();
		r1.setText(imgDesc);
		if(imgDesc.toLowerCase().contains("failed_")){
			r1.setFontColor(Color.red);
		}else {
			r1.setFontColor(Color.blue);
		}
		r1.setFontSize(24.);
	}
	
	public void addImageInToSlide(String reportScreenShotPath, Method m){
		
		XMLSlideShow ppt = new XMLSlideShow();
		File image = new File(reportScreenShotPath);
		File[] listOfImageFiles = image.listFiles();
		System.out.println(listOfImageFiles.length);
		Arrays.sort(listOfImageFiles, Comparator.comparingLong(File::lastModified));
		for (int k = 0; k < listOfImageFiles.length; k++) {

			File imgPath = listOfImageFiles[k];
			String getImageName = imgPath.getName();
			if(getImageName.contains("_")){
				String imageName = getImageName.substring(0,getImageName.length()-22);
			
				XSLFSlideMaster slideMaster = ppt.getSlideMasters().get(0);
				XSLFSlideLayout layout = slideMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
				slide = ppt.createSlide(layout);
				setTextInTitle("Description : "+imageName);
			}
			XSLFShape pic = slide.getPlaceholder(1);
			Rectangle anchor = pic.getAnchor();

			byte[] pictureData;
			try {
				pictureData = IOUtils.toByteArray(new FileInputStream(imgPath));
				XSLFPictureData idx = ppt.addPicture(pictureData, XSLFPictureData.PictureType.JPEG);
				XSLFPictureShape picture = slide.createPicture(idx);
				picture.setAnchor(anchor);

				String pptFolderPath = reportScreenShotPath + "\\PowerPoint\\";
				File pptPath = new File(pptFolderPath);
				pptPath.mkdirs();
				FileOutputStream fos = new FileOutputStream(new File(pptFolderPath + m.getName()+".pptx"));
				ppt.write(fos);
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Conversion From Image InTo PPT Is Done");
	}
}