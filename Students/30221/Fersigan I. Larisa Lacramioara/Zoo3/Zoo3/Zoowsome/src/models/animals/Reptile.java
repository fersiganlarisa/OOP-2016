package models.animals;

import static repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public abstract class Reptile extends Animal{
	public Reptile(double mc, double dp) {
		super(mc, dp);
		// TODO Auto-generated constructor stub
	}

	public boolean laysEggs;		//Does it lay eggs or not 

	public boolean isLaysEggs() {
		return laysEggs;
	}

	public void setLaysEggs(boolean laysEggs) {
		this.laysEggs = laysEggs;
	}
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {  
		super.encodeToXml(eventWriter); 
		createNode(eventWriter, "laysEggs", String.valueOf(isLaysEggs()));  
		}
	public void decodeFromXml(Element element) { 
		setTakeCareOf(Boolean.valueOf(element.getElementsByTagName("laysEggs").item(0).getTextContent())); 
	
	}  

}
