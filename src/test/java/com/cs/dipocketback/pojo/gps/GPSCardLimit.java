package com.cs.dipocketback.pojo.gps;

public class GPSCardLimit {
    
    private GPSLimitInformation limitInformation;
    private Integer cardType;
    
    public GPSCardLimit() {
    }
    
//    public GPSCardLimit(CardLimitInfo limitInfo) {
//        prepareGPSCardLimit(limitInfo);
//    }

    public void setLimitInformation(GPSLimitInformation limitInformation) {
        this.limitInformation = limitInformation;
    }

    public GPSLimitInformation getLimitInformation() {
        return limitInformation;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Integer getCardType() {
        return cardType;
    }

//    private void prepareGPSCardLimit(CardLimitInfo limitInfo) {
//        if (limitInfo == null || limitInfo.getLimitInformation() == null) {
//            return;
//        }
//
//        if (limitInfo.getLimitInformation().getSubLimits() == null ||
//            limitInfo.getLimitInformation().getSubLimits().isEmpty()) {
//            return;
//        }
//
//        List<GPSSubLimit> gpsSubLimits = new ArrayList<>();
//        for (SubLimit subLimit : limitInfo.getLimitInformation().getSubLimits()) {
//
//            if (!subLimit.getSubLimitPeriods().isEmpty()) {
//                List<GPSSubLimitPeriod> gpsPeriods = new ArrayList<>();
//                for (SubLimitPeriod period : subLimit.getSubLimitPeriods()) {
//                    gpsPeriods.add(new GPSSubLimitPeriod(period.getPeriod(), period.getUnit(),
//                                                         CommonUtils.doubleToCurrencyLong(period.getLimit()),
//                                                         period.getFrequency(), CommonUtils.doubleToCurrencyLong(period.getUsage()), 
//                                                         period.getNo()));
//                }
//                gpsSubLimits.add(new GPSSubLimit(subLimit.getProcess(),
//                                                 CommonUtils.doubleToCurrencyLong(subLimit.getMaxPerTransaction()),
//                                                 CommonUtils.doubleToCurrencyLong(subLimit.getMinPerTransaction()),
//                                                 gpsPeriods));
//            }
//        }
//        setLimitInformation(
//            new GPSLimitInformation(CommonUtils.doubleToCurrencyLong(limitInfo.getLimitInformation().getMaxAllowableBalance()),
//                                    CommonUtils.doubleToCurrencyLong(limitInfo.getLimitInformation().getMinPerTransaction()),
//                                    gpsSubLimits));
//        setCardType(limitInfo.getCardType());
//    }
}
