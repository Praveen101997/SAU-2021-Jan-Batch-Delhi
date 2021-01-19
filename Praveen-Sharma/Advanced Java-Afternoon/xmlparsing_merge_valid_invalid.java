
//Importing Libraries
import java.io.File;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class xmlparsing_merge_valid_invalid {

	//Declaration Important Data
	private static Document finaldoc;
	private static Document vdoc;
	private static Document ivdoc;
	private static Element csr_body;
	private static Element v_det;
	private static Element iv_det;

	public static void main(String[] args) {
		try {
			// Read file
			File lic1 = new File("license1.xml");
			File lic2 = new File("license2.xml");
			
			System.out.println("Reading File 1 :"+lic1.getAbsolutePath());
			System.out.println("Reading File 2 :"+lic2.getAbsolutePath());

			// Create Instance of DocumentBuilderFactory
			DocumentBuilderFactory dbFactory1 = DocumentBuilderFactory.newInstance();
			DocumentBuilderFactory dbFactory2 = DocumentBuilderFactory.newInstance();
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

			// Create a new DocumentBuilder
			DocumentBuilder dBuilder1 = dbFactory1.newDocumentBuilder();
			DocumentBuilder dBuilder2 = dbFactory2.newDocumentBuilder();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

			// Parse the license file
			Document doc1 = dBuilder1.parse(lic1);
			Document doc2 = dBuilder2.parse(lic2);
			
			System.out.println("Parsing Completed");

			// Normalize the data
			doc1.getDocumentElement().normalize();
			doc2.getDocumentElement().normalize();
			
			System.out.println("Normalization Compeleted");

			// Get all the nodes using Tag name
			NodeList nList1 = doc1.getElementsByTagName("CSR_Producer");
			NodeList nList2 = doc2.getElementsByTagName("CSR_Producer");

			finaldoc = documentBuilder.newDocument();
			Element csr_report = finaldoc.createElement("CSR_Report");
			finaldoc.appendChild(csr_report);

			Element csr_report_header = finaldoc.createElement("CSR_Report_Header");
			csr_report_header = addingAtt2Ele(csr_report_header,
					(Element) doc1.getElementsByTagName("CSR_Report_Header").item(0));
			csr_report.appendChild(csr_report_header);

			csr_body = finaldoc.createElement("CSR_Report_Body");
			csr_report.appendChild(csr_body);
			
			System.out.println("Preprocessing Final Doc Completed");

			// Getting Valid license
			vdoc = documentBuilder.newDocument();
			v_det = vdoc.createElement("Licences_VALID");
			vdoc.appendChild(v_det);

			// Getting invalid license
			ivdoc = documentBuilder.newDocument();
			iv_det = ivdoc.createElement("Licenses_INVALID");
			ivdoc.appendChild(iv_det);

			//Matching for merginf licenses
			match(nList2, nList1, "NIPR_Number");

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			DOMSource domSource = new DOMSource(finaldoc);
			File file = new File("merged_licenses.xml");
			StreamResult streamResult = new StreamResult(file);
			transformer.transform(domSource, streamResult);
			
			System.out.println("Merged XML file Saved at : "+file.getAbsolutePath());

			DOMSource validdomSource = new DOMSource(vdoc);
			file = new File("valid_licenses.xml");
			StreamResult validstreamResult = new StreamResult(file);
			transformer.transform(validdomSource, validstreamResult);

			System.out.println("Valid XML file Saved at : "+file.getAbsolutePath());
			
			DOMSource invaliddomSource = new DOMSource(ivdoc);
			file = new File("invalid_licenses.xml");
			StreamResult invalidstreamResult = new StreamResult(file);
			transformer.transform(invaliddomSource, invalidstreamResult);
			
			System.out.println("Invalid XML file Saved at : "+file.getAbsolutePath());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void match(NodeList first, NodeList second, String Key) {
		System.out.println("Matching Started");
		for (int i = 0; i < first.getLength(); i++) {
			Element fEle = (Element) first.item(i);
			for (int j = 0; j < second.getLength(); j++) {
				Element cisr_producer = finaldoc.createElement("CISR_PRODUCER");

				Element sEle = (Element) second.item(j);
				String fNipr = (fEle.getAttribute(Key));
				String sNipr = sEle.getAttribute(Key);

				if (fNipr.equals(sNipr)) {
					cisr_producer = addingAtt2Ele(cisr_producer, fEle);
					cisr_producer = matchLicense(fEle.getElementsByTagName("License"),
							sEle.getElementsByTagName("License"), "Date_Status_Effective", "State_Code",
							"License_Number", cisr_producer);
					csr_body.appendChild(cisr_producer);
				}
			}
		}
		System.out.println("Matching Completed");

		for (int i = 0; i < first.getLength(); i++) {
			Element cEl = (Element) first.item(i);
			viFilter(cEl.getElementsByTagName("License"));
		}
		
		System.out.println("Got Valid and invalid data from 1st license");
		
		for (int i = 0; i < second.getLength(); i++) {
			Element cEl = (Element) second.item(i);
			viFilter(cEl.getElementsByTagName("License"));
		}
		
		System.out.println("Got Valid and invalid data from 2nd license");
	}

	//Matching license using nodes
	public static Element matchLicense(NodeList fnode, NodeList snode, String key, String key1, String key2,
			Element cisr_producer) {
		try {
			for (int i = 0; i < fnode.getLength(); i++) {
				Element fNEle = (Element) fnode.item(i);
				for (int j = 0; j < snode.getLength(); j++) {
					Element sNEle = (Element) snode.item(j);
					if (fNEle.getAttribute(key).equals(sNEle.getAttribute(key))
							&& fNEle.getAttribute(key1).equals(sNEle.getAttribute(key1))
							&& fNEle.getAttribute(key2).equals(sNEle.getAttribute(key2))) {
						Element License = finaldoc.createElement("License");
						addingAtt2Ele(License, fNEle);

						NodeList Loa = fNEle.getElementsByTagName("LOA");
						NodeList Loa2 = sNEle.getElementsByTagName("LOA");

						for (int k = 0; k < Loa.getLength(); k++) {
							Element newLoa = finaldoc.createElement(Loa.item(k).getNodeName());
							addingAtt2Ele(newLoa, (Element) Loa.item(k));
							License.appendChild(newLoa);
						}
						for (int k = 0; k < Loa2.getLength(); k++) {
							Element newLoa = finaldoc.createElement(Loa2.item(k).getNodeName());
							addingAtt2Ele(newLoa, (Element) Loa2.item(k));
							License.appendChild(newLoa);
						}
						cisr_producer.appendChild(License);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cisr_producer;
	}

	// Filterring Valid and Invalid Nodes
	private static void viFilter(NodeList fNode) {

		for (int i = 0; i < fNode.getLength(); i++) {

			Element cEle = (Element) fNode.item(i);
			String[] datedata = cEle.getAttribute("License_Expiration_Date").split("/");
			LocalDate expDate = LocalDate.parse(datedata[2] + '-' + datedata[0] + '-' + datedata[1]);

			long diff = ChronoUnit.DAYS.between(LocalDate.now(), expDate);
			if (diff > 0) {
				v_det.appendChild(vLicNCopy(cEle));
			} else {
				iv_det.appendChild(ivLicNCopy(cEle));
			}
		}

	}

	// Invalid Licence Nodes Copy
	private static Element ivLicNCopy(Element source) {
		Element lic = ivdoc.createElement(source.getNodeName());
		lic = addingAtt2Ele(lic, source);

		NodeList Loas = source.getElementsByTagName("LOA");
		for (int i = 0; i < Loas.getLength(); i++) {
			Element cLoa = (Element) Loas.item(i);
			Element nLoa = ivdoc.createElement(cLoa.getNodeName());
			nLoa = addingAtt2Ele(nLoa, cLoa);
			lic.appendChild(nLoa);
		}
		return lic;
	}

	// Valid Licence Nodes Copy
	private static Element vLicNCopy(Element src) {
		Element lic = vdoc.createElement(src.getNodeName());
		lic = addingAtt2Ele(lic, src);

		NodeList Loas = src.getElementsByTagName("LOA");
		for (int i = 0; i < Loas.getLength(); i++) {
			Element cLoa = (Element) Loas.item(i);
			Element nLoa = vdoc.createElement(cLoa.getNodeName());
			nLoa = addingAtt2Ele(nLoa, cLoa);
			lic.appendChild(nLoa);
		}
		return lic;
	}

	// Adding Attributes to elements
	private static Element addingAtt2Ele(Element nEle, Element oEle) {
		NamedNodeMap att = oEle.getAttributes();
		for (int i = 0; i < att.getLength(); i++) {
			nEle.setAttribute(att.item(i).getNodeName(), att.item(i).getNodeValue());
		}
		return nEle;
	}

}