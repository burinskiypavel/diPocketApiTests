package com.cs.dipocketback.pojo.client;

//import com.cs.dipocketback.base.data.Site;
import com.cs.dipocketback.base.data.Site;
import com.cs.dipocketback.pojo.registration.RegImageData;

import java.util.List;

@Deprecated
public class WebClientInfo extends ClientInfo {
    
    public WebClientInfo() {
        super();
    }
    
    public WebClientInfo(Long id, 
                         String clientFirstName, 
                         String clientMiddleName, 
                         String clientLastName,
                         String presentedLogin, 
                         Integer countryId, 
                         Integer residenceCountryId, 
                         Integer langId,
                         String mainPhone, 
                         String email, 
                         Boolean emailIsVerified, 
                         Integer currencyId, 
                         String secQuestion,
                         Integer secAnswerAttemptCnt, 
                         Integer stateId,
                         Boolean addDocsAvail, 
                         String ccyCode,
                         String birthDate, 
                         String birthDateAsDate, 
                         String ddStatus, 
                         String cardholderName,
                         Boolean registeredAddrAsmail, 
                         CardholderNameState cardholderNameState, 
                         String site, 
                         String externalNo, 
                         String identifyCode,
                         Boolean isStrongPassword,
                         ClientType clientType,
                         String blockReason) {
        super(id, 
              clientFirstName, 
              clientMiddleName,
              clientLastName,
              presentedLogin, 
              countryId, 
              residenceCountryId,
              langId, 
              mainPhone, 
              email, 
              emailIsVerified, 
              currencyId, 
              secQuestion, 
              secAnswerAttemptCnt, 
              stateId,
              addDocsAvail, 
              ccyCode, 
              birthDate, 
              birthDateAsDate, 
              ddStatus, 
              cardholderName, 
              registeredAddrAsmail,
              cardholderNameState,
              site, 
              Site.getSiteByName(site),
              externalNo, 
              identifyCode,
              isStrongPassword,
              clientType,
              blockReason);
    }
    
    public WebClientInfo(ClientInfo cl) {
        super(cl.getId(), 
              cl.getClientFirstName(), 
              cl.getClientMiddleName(),
              cl.getClientLastName(),
              cl.getPresentedLogin(),
              cl.getCountryId(),
              cl.getResidenceCountryId(),
              cl.getLangId(),
              cl.getMainPhone(),
              cl.getEmail(),
              cl.getEmailIsVerified(),
              cl.getCurrencyId(),
              cl.getSecQuestion(),
              cl.getSecAnswerAttemptCnt(),
              cl.getStateId(),
              cl.getAddDocsAvail(),
              cl.getCcyCode(),
              cl.getBirthDate(),
              cl.getBirthDateAsDate(),
              cl.getDdStatus(),
              cl.getCardholderName(),
              cl.getRegisteredAddrAsmail(),
              cl.getCardholderNameState(),
              cl.getSite(),
              cl.getSiteEnum(),
              cl.getExternalNo(),
              cl.getIdentifyCode(),
              cl.getIsStrongPassword(),
              cl.getClientType(),
              cl.getBlockReason());
    }

    @Override
    public List<RegImageData> getImages() {
        return null;
    }
    
}
