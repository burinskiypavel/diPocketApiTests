package appmanager;

import model.*;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class XmlHelper extends HelperBase {
    public void checkTextInCollectionEntryName(List<Entry> listEnty, String text) {
        List<Entry> result = listEnty.stream()
                .filter(line -> text.equals(line.getName()))
                .collect(Collectors.toList());

        if(result.size() == 0){
            Assert.fail("Filter result is empty " + text + " is not in the list");
        }
        for(Entry element : result){
            element.getName();
            Assert.assertEquals(element.getName(), text);
        }
    }

    public void checkTextInCollectionEntryName(List<Entry> listEnty, String[] textArr) {
        for(int i = 0; i < textArr.length; i++) {
            int finalI = i;
            List<Entry> result = listEnty.stream()
                    .filter(line -> textArr[finalI].equals(line.getName()))
                    .collect(Collectors.toList());

            if(result.size() == 0){
                Assert.fail("Filter result is empty " + textArr[i]+ " is not in the list");
            }

            for (Entry element : result) {
                element.getName();
                Assert.assertEquals(element.getName(), textArr[i]);
            }

        }
    }

    public void checkTextInCollectionEntryValue(List<Entry> listEnty, String[] textArr) {
        for(int i = 0; i < textArr.length; i++) {
            int finalI = i;
            List<Entry> result = listEnty.stream()
                    .filter(line -> textArr[finalI].equals(line.getValue()))
                    .collect(Collectors.toList());

            if(result.size() == 0){
                Assert.fail("Filter result is empty " + textArr[i]+ " is not in the list");
            }

            for (Entry element : result) {
                element.getValue();
                Assert.assertEquals(element.getValue(), textArr[i]);
            }

        }
    }

    public void checkTextInCollectionEntryValue(List<Entry> listEnty, String text) {
        List<Entry> result = listEnty.stream()
                .filter(line -> text.equals(line.getValue()))
                .collect(Collectors.toList());
        if(result.size() == 0){
            Assert.fail("Filter result is empty " + text + " is not in the list");
        }
        for(Entry element : result){
            element.getName();
            Assert.assertEquals(element.getValue(), text);
        }
    }

    public Document initXmlParsing(String response) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(new ByteArrayInputStream(response.getBytes()));
        System.out.println("\nRoot element :" + document.getDocumentElement().getNodeName());
        return document;
    }

    public List<Entry> parseXmlSetNameSetValueFromEntryAddThemToCollection(Document document, BackgroudResponse backgroudResponse) {
        List<Entry> listEnty = new ArrayList<>();

        NodeList entryList = document.getElementsByTagName("entry");

        System.out.println("----------------------------");

        for (int i = 0; i < entryList.getLength(); i++) {

            Node nNode = entryList.item(i);

            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;

                Entry entry = new Entry();
                entry.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                entry.setValue(eElement.getElementsByTagName("value").item(0).getTextContent());

                System.out.println("name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("value : " + eElement.getElementsByTagName("value").item(0).getTextContent());

                listEnty.add(entry);
                //backgroudResponse.setEntries(listEnty);
            }
        }
        return listEnty;
    }

    public List<Entry> parseXmlSetNameSetValueFromEntryAddThemToCollection(Document document) {
        List<Entry> listEnty = new ArrayList<>();

        NodeList entryList = document.getElementsByTagName("entry");

        System.out.println("----------------------------");

        for (int i = 0; i < entryList.getLength(); i++) {

            Node nNode = entryList.item(i);

            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;

                Entry entry = new Entry();
                entry.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                entry.setValue(eElement.getElementsByTagName("value").item(0).getTextContent());

                System.out.println("name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("value : " + eElement.getElementsByTagName("value").item(0).getTextContent());

                listEnty.add(entry);
                //backgroudResponse.setEntries(listEnty);
            }
        }
        return listEnty;
    }

    public BackgroudResponse parseXmlResponseSetDataStatusSetPageId(Document document) {
        BackgroudResponse backgroudResponse = new BackgroudResponse();

        Element dataStatusElement = (Element) document.getElementsByTagName("dataStatus").item(0);
        System.out.println("dataStatus " + dataStatusElement.getTextContent());
        backgroudResponse.setDataStatus(dataStatusElement.getTextContent());

        Element pageIdElement = (Element) document.getElementsByTagName("pageId").item(0);
        System.out.println("pageId " + pageIdElement.getTextContent());
        backgroudResponse.setPageId(pageIdElement.getTextContent());

        return backgroudResponse;
    }

    public BackgroundCRes parseXmlResponseReturnBackgroundCResObject(Document document) {
        BackgroundCRes backgroudCRes = new BackgroundCRes();

        Element acsTransIDElement = (Element) document.getElementsByTagName("acsTransID").item(0);
        System.out.println("acsTransID " + acsTransIDElement.getTextContent());
        backgroudCRes.setAcsTransID(acsTransIDElement.getTextContent());

        Element messageTypeElement = (Element) document.getElementsByTagName("messageType").item(0);
        System.out.println("messageType " + messageTypeElement.getTextContent());
        backgroudCRes.setMessageType(messageTypeElement.getTextContent());

        Element messageVersionElement = (Element) document.getElementsByTagName("messageVersion").item(0);
        System.out.println("messageVersion " + messageVersionElement.getTextContent());
        backgroudCRes.setMessageVersion(messageVersionElement.getTextContent());

        Element pageIdElement = (Element) document.getElementsByTagName("pageId").item(0);
        System.out.println("pageId " + pageIdElement.getTextContent());
        backgroudCRes.setPageId(pageIdElement.getTextContent());

        Element challengeCompletionIndElement = (Element) document.getElementsByTagName("challengeCompletionInd").item(0);
        System.out.println("challengeCompletionInd " + challengeCompletionIndElement.getTextContent());
        backgroudCRes.setChallengeCompletionInd(challengeCompletionIndElement.getTextContent());

        return backgroudCRes;
    }

    public FinalCRes parseXmlResponseReturnFinalCResObject(Document document) {
        FinalCRes finalCRes = new FinalCRes();

        Element acsTransIDElement = (Element) document.getElementsByTagName("acsTransID").item(0);
        System.out.println("acsTransID " + acsTransIDElement.getTextContent());
        finalCRes.setAcsTransID(acsTransIDElement.getTextContent());

        Element messageTypeElement = (Element) document.getElementsByTagName("messageType").item(0);
        System.out.println("messageType " + messageTypeElement.getTextContent());
        finalCRes.setMessageType(messageTypeElement.getTextContent());

        Element messageVersionElement = (Element) document.getElementsByTagName("messageVersion").item(0);
        System.out.println("messageVersion " + messageVersionElement.getTextContent());
        finalCRes.setMessageVersion(messageVersionElement.getTextContent());

        Element transStatusElement = (Element) document.getElementsByTagName("transStatus").item(0);
        System.out.println("transStatus " + transStatusElement.getTextContent());
        finalCRes.setTransStatus(transStatusElement.getTextContent());

        Element challengeCompletionIndElement = (Element) document.getElementsByTagName("challengeCompletionInd").item(0);
        System.out.println("challengeCompletionInd " + challengeCompletionIndElement.getTextContent());
        finalCRes.setChallengeCompletionInd(challengeCompletionIndElement.getTextContent());

        return finalCRes;
    }

    public FinalCResDecline parseXmlResponseReturnFinalCResDeclineObject(Document document) {
        FinalCResDecline finalCResDecline = new FinalCResDecline();

        Element acsTransIDElement = (Element) document.getElementsByTagName("acsTransID").item(0);
        System.out.println("acsTransID " + acsTransIDElement.getTextContent());
        finalCResDecline.setAcsTransID(acsTransIDElement.getTextContent());

        Element messageTypeElement = (Element) document.getElementsByTagName("messageType").item(0);
        System.out.println("messageType " + messageTypeElement.getTextContent());
        finalCResDecline.setMessageType(messageTypeElement.getTextContent());

        Element messageVersionElement = (Element) document.getElementsByTagName("messageVersion").item(0);
        System.out.println("messageVersion " + messageVersionElement.getTextContent());
        finalCResDecline.setMessageVersion(messageVersionElement.getTextContent());

        Element transStatusElement = (Element) document.getElementsByTagName("transStatus").item(0);
        System.out.println("transStatus " + transStatusElement.getTextContent());
        finalCResDecline.setTransStatus(transStatusElement.getTextContent());

        Element transStatusReasonElement = (Element) document.getElementsByTagName("transStatusReason").item(0);
        System.out.println("transStatusReason " + transStatusReasonElement.getTextContent());
        finalCResDecline.setTransStatusReason(transStatusReasonElement.getTextContent());

        Element challengeCompletionIndElement = (Element) document.getElementsByTagName("challengeCompletionInd").item(0);
        System.out.println("challengeCompletionInd " + challengeCompletionIndElement.getTextContent());
        finalCResDecline.setChallengeCompletionInd(challengeCompletionIndElement.getTextContent());

        return finalCResDecline;
    }

    public BackgroundARes parseXmlResponseReturnBackgroundAResObject(Document document) {
        BackgroundARes backgroundARes = new BackgroundARes();

        Element acsTransIDElement = (Element) document.getElementsByTagName("acsTransID").item(0);
        System.out.println("acsTransID " + acsTransIDElement.getTextContent());
        backgroundARes.setAcsTransID(acsTransIDElement.getTextContent());

        Element acsChallengeMandatedElement = (Element) document.getElementsByTagName("acsChallengeMandated").item(0);
        System.out.println("acsChallengeMandated " + acsChallengeMandatedElement.getTextContent());
        backgroundARes.setAcsChallengeMandated(acsChallengeMandatedElement.getTextContent());

        Element authenticationTypeElement = (Element) document.getElementsByTagName("authenticationType").item(0);
        System.out.println("authenticationType " + authenticationTypeElement.getTextContent());
        backgroundARes.setAuthenticationType(authenticationTypeElement.getTextContent());

        Element messageTypeElement = (Element) document.getElementsByTagName("messageType").item(0);
        System.out.println("messageType " + messageTypeElement.getTextContent());
        backgroundARes.setMessageType(messageTypeElement.getTextContent());

        Element messageVersionElement = (Element) document.getElementsByTagName("messageVersion").item(0);
        System.out.println("messageVersion " + messageVersionElement.getTextContent());
        backgroundARes.setMessageVersion(messageVersionElement.getTextContent());

        Element transStatusElement = (Element) document.getElementsByTagName("transStatus").item(0);
        System.out.println("transStatus " + transStatusElement.getTextContent());
        backgroundARes.setTransStatus(transStatusElement.getTextContent());

        return backgroundARes;
    }

    public BackgroundARes parseXmlResponseReturnBackgroundAResAllFieldsObject(Document document) {
        BackgroundARes backgroundARes = new BackgroundARes();

        Element acsTransIDElement = (Element) document.getElementsByTagName("acsTransID").item(0);
        System.out.println("acsTransID " + acsTransIDElement.getTextContent());
        backgroundARes.setAcsTransID(acsTransIDElement.getTextContent());

        Element acsChallengeMandatedElement = (Element) document.getElementsByTagName("acsChallengeMandated").item(0);
        System.out.println("acsChallengeMandated " + acsChallengeMandatedElement.getTextContent());
        backgroundARes.setAcsChallengeMandated(acsChallengeMandatedElement.getTextContent());

        Element messageTypeElement = (Element) document.getElementsByTagName("messageType").item(0);
        System.out.println("messageType " + messageTypeElement.getTextContent());
        backgroundARes.setMessageType(messageTypeElement.getTextContent());

        Element messageVersionElement = (Element) document.getElementsByTagName("messageVersion").item(0);
        System.out.println("messageVersion " + messageVersionElement.getTextContent());
        backgroundARes.setMessageVersion(messageVersionElement.getTextContent());

        Element transStatusElement = (Element) document.getElementsByTagName("transStatus").item(0);
        System.out.println("transStatus " + transStatusElement.getTextContent());
        backgroundARes.setTransStatus(transStatusElement.getTextContent());

        return backgroundARes;
    }

    public BackgroundAResDecline parseXmlResponseReturnBackgroundAResDeclinedObject(Document document) {
        BackgroundAResDecline backgroundAResDecline = new BackgroundAResDecline();

        Element backgroundResponse2Element = (Element) document.getElementsByTagName("backgroundResponse2").item(0);
        Element backgroundAResElement = (Element) backgroundResponse2Element.getElementsByTagName("backgroundARes").item(0);

        Element acsTransIDElement = (Element) backgroundAResElement.getElementsByTagName("acsTransID").item(0);
        System.out.println("acsTransID " + acsTransIDElement.getTextContent());
        backgroundAResDecline.setAcsTransID(acsTransIDElement.getTextContent());

        Element messageTypeElement = (Element) backgroundAResElement.getElementsByTagName("messageType").item(0);
        System.out.println("messageType " + messageTypeElement.getTextContent());
        backgroundAResDecline.setMessageType(messageTypeElement.getTextContent());

        Element messageVersionElement = (Element) backgroundAResElement.getElementsByTagName("messageVersion").item(0);
        System.out.println("messageVersion " + messageVersionElement.getTextContent());
        backgroundAResDecline.setMessageVersion(messageVersionElement.getTextContent());

        Element transStatusElement = (Element) backgroundAResElement.getElementsByTagName("transStatus").item(0);
        System.out.println("transStatus " + transStatusElement.getTextContent());
        backgroundAResDecline.setTransStatus(transStatusElement.getTextContent());

        Element transStatusReasonElement = (Element) backgroundAResElement.getElementsByTagName("transStatusReason").item(0);
        System.out.println("transStatusReason " + transStatusReasonElement.getTextContent());
        backgroundAResDecline.setTransStatusReason(transStatusReasonElement.getTextContent());

        return backgroundAResDecline;
    }

    public OOBBackgroundCRes parseXmlReturnOOBBackgroundCResObject(Document document) {
        OOBBackgroundCRes oobBackgroundCRes = new OOBBackgroundCRes();

        Element backgroundResponse2Element = (Element) document.getElementsByTagName("backgroundResponse2").item(0);
        Element backgroundCResElement = (Element) backgroundResponse2Element.getElementsByTagName("backgroundCRes").item(0);
        Element InProgressCResElement = (Element) backgroundCResElement.getElementsByTagName("InProgressCRes").item(0);

        Element acsTransIDElement = (Element) InProgressCResElement.getElementsByTagName("acsTransID").item(0);
        System.out.println("acsTransID " + acsTransIDElement.getTextContent());
        oobBackgroundCRes.setAcsTransID(acsTransIDElement.getTextContent());

        Element acsCounterAtoSElement = (Element) InProgressCResElement.getElementsByTagName("acsCounterAtoS").item(0);
        System.out.println("acsCounterAtoS " + acsCounterAtoSElement.getTextContent());
        oobBackgroundCRes.setAcsCounterAtoS(acsCounterAtoSElement.getTextContent());

        Element acsUiTypeElement = (Element) InProgressCResElement.getElementsByTagName("acsUiType").item(0);
        System.out.println("acsUiType " + acsUiTypeElement.getTextContent());
        oobBackgroundCRes.setAcsUiType(acsUiTypeElement.getTextContent());

        Element challengeInfoHeaderElement = (Element) InProgressCResElement.getElementsByTagName("challengeInfoHeader").item(0);
        System.out.println("challengeInfoHeader " + challengeInfoHeaderElement.getTextContent());
        oobBackgroundCRes.setChallengeInfoHeader(challengeInfoHeaderElement.getTextContent());

        Element challengeInfoTextElement = (Element) InProgressCResElement.getElementsByTagName("challengeInfoText").item(0);
        System.out.println("challengeInfoText " + challengeInfoTextElement.getTextContent());

        String text = challengeInfoTextElement.getTextContent();

                text = text.replaceAll("&#xD;&#xA;", " ");

        oobBackgroundCRes.setChallengeInfoText(text);

        Element expandInfoLabelElement = (Element) InProgressCResElement.getElementsByTagName("expandInfoLabel").item(0);
        System.out.println("expandInfoLabel " + expandInfoLabelElement.getTextContent());
        oobBackgroundCRes.setExpandInfoLabel(expandInfoLabelElement.getTextContent());

        Element expandInfoTextElement = (Element) InProgressCResElement.getElementsByTagName("expandInfoText").item(0);
        System.out.println("expandInfoText " + expandInfoTextElement.getTextContent());
        oobBackgroundCRes.setExpandInfoText(expandInfoTextElement.getTextContent());

        Element issuerImageElement = (Element) InProgressCResElement.getElementsByTagName("issuerImage").item(0);
        System.out.println("issuerImage " + issuerImageElement.getTextContent());
        oobBackgroundCRes.setIssuerImage(issuerImageElement.getTextContent());

        Element psImageElement = (Element) InProgressCResElement.getElementsByTagName("psImage").item(0);
        System.out.println("psImage " + psImageElement.getTextContent());
        oobBackgroundCRes.setPsImage(psImageElement.getTextContent());

        Element messageTypeElement = (Element) InProgressCResElement.getElementsByTagName("messageType").item(0);
        System.out.println("messageType " + messageTypeElement.getTextContent());
        oobBackgroundCRes.setMessageType(messageTypeElement.getTextContent());

        Element messageVersionElement = (Element) InProgressCResElement.getElementsByTagName("messageVersion").item(0);
        System.out.println("messageVersion " + messageVersionElement.getTextContent());
        oobBackgroundCRes.setMessageVersion(messageVersionElement.getTextContent());

        Element oobContinueLabelElement = (Element) InProgressCResElement.getElementsByTagName("oobContinueLabel").item(0);
        System.out.println("oobContinueLabel " + oobContinueLabelElement.getTextContent());
        oobBackgroundCRes.setOobContinueLabel(oobContinueLabelElement.getTextContent());

        Element challengeCompletionIndElement = (Element) InProgressCResElement.getElementsByTagName("challengeCompletionInd").item(0);
        System.out.println("challengeCompletionInd " + challengeCompletionIndElement.getTextContent());
        oobBackgroundCRes.setChallengeCompletionInd(challengeCompletionIndElement.getTextContent());

        return oobBackgroundCRes;
    }

    public OOBBackgroundCRes parseXmlReturnOOBBackgroundCResObject_NativeOOOBHtml(Document document) {
        OOBBackgroundCRes oobBackgroundCRes = new OOBBackgroundCRes();

        Element backgroundResponse2Element = (Element) document.getElementsByTagName("backgroundResponse2").item(0);
        Element backgroundCResElement = (Element) backgroundResponse2Element.getElementsByTagName("backgroundCRes").item(0);
        Element InProgressCResElement = (Element) backgroundCResElement.getElementsByTagName("InProgressCRes").item(0);

        Element acsTransIDElement = (Element) InProgressCResElement.getElementsByTagName("acsTransID").item(0);
        System.out.println("acsTransID " + acsTransIDElement.getTextContent());
        oobBackgroundCRes.setAcsTransID(acsTransIDElement.getTextContent());

        Element acsCounterAtoSElement = (Element) InProgressCResElement.getElementsByTagName("acsCounterAtoS").item(0);
        System.out.println("acsCounterAtoS " + acsCounterAtoSElement.getTextContent());
        oobBackgroundCRes.setAcsCounterAtoS(acsCounterAtoSElement.getTextContent());

        Element acsUiTypeElement = (Element) InProgressCResElement.getElementsByTagName("acsUiType").item(0);
        System.out.println("acsUiType " + acsUiTypeElement.getTextContent());
        oobBackgroundCRes.setAcsUiType(acsUiTypeElement.getTextContent());

        Element messageTypeElement = (Element) InProgressCResElement.getElementsByTagName("messageType").item(0);
        System.out.println("messageType " + messageTypeElement.getTextContent());
        oobBackgroundCRes.setMessageType(messageTypeElement.getTextContent());

        Element messageVersionElement = (Element) InProgressCResElement.getElementsByTagName("messageVersion").item(0);
        System.out.println("messageVersion " + messageVersionElement.getTextContent());
        oobBackgroundCRes.setMessageVersion(messageVersionElement.getTextContent());

        Element backgroundPageRequestElement = (Element) InProgressCResElement.getElementsByTagName("backgroundPageRequest").item(0);
        Element pageIdElement = (Element) backgroundPageRequestElement.getElementsByTagName("pageId").item(0);
        System.out.println("pageId " + pageIdElement.getTextContent());
        oobBackgroundCRes.setPageId(pageIdElement.getTextContent());

        Element challengeCompletionIndElement = (Element) InProgressCResElement.getElementsByTagName("challengeCompletionInd").item(0);
        System.out.println("challengeCompletionInd " + challengeCompletionIndElement.getTextContent());
        oobBackgroundCRes.setChallengeCompletionInd(challengeCompletionIndElement.getTextContent());

        return oobBackgroundCRes;
    }

    public NativeSms parseXmlReturnNativeSmsObject(Document document) {
        NativeSms nativeSms = new NativeSms();

        Element backgroundResponse2Element = (Element) document.getElementsByTagName("backgroundResponse2").item(0);
        Element backgroundCResElement = (Element) backgroundResponse2Element.getElementsByTagName("backgroundCRes").item(0);
        Element InProgressCResElement = (Element) backgroundCResElement.getElementsByTagName("InProgressCRes").item(0);

        Element acsTransIDElement = (Element) InProgressCResElement.getElementsByTagName("acsTransID").item(0);
        System.out.println("acsTransID " + acsTransIDElement.getTextContent());
        nativeSms.setAcsTransID(acsTransIDElement.getTextContent());

        Element acsCounterAtoSElement = (Element) InProgressCResElement.getElementsByTagName("acsCounterAtoS").item(0);
        System.out.println("acsCounterAtoS " + acsCounterAtoSElement.getTextContent());
        nativeSms.setAcsCounterAtoS(acsCounterAtoSElement.getTextContent());

        Element acsUiTypeElement = (Element) InProgressCResElement.getElementsByTagName("acsUiType").item(0);
        System.out.println("acsUiType " + acsUiTypeElement.getTextContent());
        nativeSms.setAcsUiType(acsUiTypeElement.getTextContent());


        Element challengeInfoHeaderElement = (Element) InProgressCResElement.getElementsByTagName("challengeInfoHeader").item(0);
        System.out.println("challengeInfoHeader " + challengeInfoHeaderElement.getTextContent());
        nativeSms.setChallengeInfoHeader(challengeInfoHeaderElement.getTextContent());

        Element challengeInfoLabelElement = (Element) InProgressCResElement.getElementsByTagName("challengeInfoLabel").item(0);
        System.out.println("challengeInfoLabel " + challengeInfoLabelElement.getTextContent());
        nativeSms.setChallengeInfoLabel(challengeInfoLabelElement.getTextContent());


        Element challengeInfoTextElement = (Element) InProgressCResElement.getElementsByTagName("challengeInfoText").item(0);
        System.out.println("challengeInfoText " + challengeInfoTextElement.getTextContent());
        nativeSms.setChallengeInfoText(challengeInfoTextElement.getTextContent().toString());


        Element issuerImageElement = (Element) InProgressCResElement.getElementsByTagName("issuerImage").item(0);
        System.out.println("issuerImage " + issuerImageElement.getTextContent());
        nativeSms.setIssuerImage(issuerImageElement.getTextContent());

        Element psImageElement = (Element) InProgressCResElement.getElementsByTagName("psImage").item(0);
        System.out.println("psImage " + psImageElement.getTextContent());
        nativeSms.setPsImage(psImageElement.getTextContent());


        Element messageTypeElement = (Element) InProgressCResElement.getElementsByTagName("messageType").item(0);
        System.out.println("messageType " + messageTypeElement.getTextContent());
        nativeSms.setMessageType(messageTypeElement.getTextContent());

        Element messageVersionElement = (Element) InProgressCResElement.getElementsByTagName("messageVersion").item(0);
        System.out.println("messageVersion " + messageVersionElement.getTextContent());
        nativeSms.setMessageVersion(messageVersionElement.getTextContent());

        Element submitAuthenticationLabelElement = (Element) InProgressCResElement.getElementsByTagName("submitAuthenticationLabel").item(0);
        System.out.println("submitAuthenticationLabel " + submitAuthenticationLabelElement.getTextContent());
        nativeSms.setSubmitAuthenticationLabel(submitAuthenticationLabelElement.getTextContent());

        Element challengeCompletionIndElement = (Element) InProgressCResElement.getElementsByTagName("challengeCompletionInd").item(0);
        System.out.println("challengeCompletionInd " + challengeCompletionIndElement.getTextContent());
        nativeSms.setChallengeCompletionInd(challengeCompletionIndElement.getTextContent());

        return nativeSms;
    }

    public Document initParseXmlFromFile() throws ParserConfigurationException, SAXException, IOException {
        File fXmlFile = new File("files/response.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        return doc;
    }
}
