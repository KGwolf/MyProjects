package com.xht.springbootsourcetest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class SpringBootSourceTestApplicationTests {

    @Test
    void contextLoads() {
        String inputJsonStr = "{\"RequestSource\":null,\"PassClient\":{\"HospID\":\"hiscode00001\",\"HospName\":\"\",\"UserId\":\"KZYS001\",\"UserName\":\"\",\"DeptID\":\"\",\"DeptName\":\"\",\"IP\":\"172.18.3.154\",\"PCName\":\"liuxiaoliu\",\"OSInfo\":\"Windows 10.0\",\"Resolution\":\"1920 * 1080\",\"PassVersion\":\"1\",\"ClientInfo\":\"KZYS001_172.18.3.154_liuxiaoliu_Windows 10.0_22844\",\"ProductCode\":\"mlf35wieQdgHJ478gk06slVGSMrhy9Y2yjfhlkTv1\",\"IsPassTool\":0,\"mac\":\"\",\"otherinfo\":\"\",\"CheckMode\":\"mz\",\"BusinessDebug\":0,\"ClientVersion\":2303},\"Patient\":{\"PatCode\":\"202302081506\",\"InHospNo\":\"ZYH06-01\",\"VisitCode\":\"ZYBS06-01\",\"Name\":\"06-01剂量范围系黑灯\",\"Sex\":\"男\",\"Birthday\":\"1982-10-14\",\"HeightCM\":\"\",\"WeighKG\":\"69\",\"DeptCode\":\"EK\",\"DeptName\":\"儿科\",\"DoctorCode\":\"YS001\",\"DoctorName\":\"医生001\",\"PatStatus\":2,\"IsLactation\":-1,\"IsPregnancy\":-1,\"PregStartDate\":\"\",\"HepDamageDegree\":-1,\"RenDamageDegree\":-1,\"UseTime\":\"2017-02-08 00:00:00\",\"CheckMode\":\"mz\",\"IsDoSave\":1,\"Age\":\"\",\"PayClass\":\"\",\"IsTestEtiology\":0,\"InHospDate\":\"2017-02-08 00:00:00\",\"OutHospDate\":\"\",\"IDCard\":\"\",\"Telephone\":\"\",\"Multidaydosepriv\":\"0\",\"BirthdayDesc\":\"\",\"HeightCMDesc\":\"\",\"HeightSource\":\"HIS\",\"WeightKGDesc\":\"\",\"WeightSource\":\"HIS\",\"BodyArea\":\"未测量\",\"BodyAreaCalc\":\"未测量\",\"InterPrescno\":\"\",\"WardCode\":\"\",\"WardDesc\":\"\",\"AntiEvaluate\":\"\",\"DoucmentNo\":\"\"},\"ScreenAllergenList\":{\"ScreenAllergens\":[]},\"ScreenMedCondList\":{\"ScreenMedConds\":[]},\"ScreenOperationList\":{\"ScreenOperations\":[]},\"ScreenDrugList\":{\"ScreenDrugs\":[{\"RecipNo\":\"\",\"Index\":\"121\",\"OrderNo\":12,\"DrugSource\":\"USER\",\"DrugUniqueCode\":\"16596+吡喹酮片+片+200mg+四川科伦药业股份有限公司\",\"DrugCode\":\"\",\"DrugName\":\"吡喹酮片\",\"DoseUnit\":\"mg\",\"Form\":\"\",\"Strength\":\"\",\"CompName\":\"\",\"RouteSource\":\"USER\",\"RouteCode\":\"122\",\"RouteName\":\"口服\",\"FreqSource\":\"USER\",\"Frequency\":\"3/1\",\"DosePerTime\":\"5000\",\"StartTime\":\"2017-02-08\",\"EndTime\":\"2017-03-12\",\"ExecuteTime\":\"\",\"DeptName\":\"儿科\",\"DeptCode\":\"EK\",\"DoctorCode\":\"YS001\",\"DoctorName\":\"医生001\",\"GroupTag\":\"\",\"IsTempDrug\":0,\"OrderType\":0,\"Pharmacists\":\"\",\"Pharmacists_\":\"\",\"Num\":\"\",\"NumUnit\":\"\",\"Cost\":\"\",\"Purpose\":0,\"OprCode\":\"\",\"MediTime\":\"\",\"Remark\":\"\",\"Evaluate\":\"\"}]},\"InputJsonInfoList\":{\"InputJsonInfos\":[{\"type\":\"patientinfo\",\"inhospdate\":\"2017-02-08 00:00:00\",\"bedno\":\"\",\"doucmentno\":\"\",\"age\":\"34.3452054794521\",\"idcard\":\"\",\"telephone\":\"\",\"patlevel\":\"\",\"urgent\":0,\"multidaydosepriv\":0,\"isdialysis\":-1,\"isfast\":1,\"hospitallevel\":0,\"medicalcharge\":2,\"medicaretype\":\"-1\",\"wardcode\":\"\",\"warddesc\":\"\",\"consultation\":-1,\"costtype\":\"\",\"temperature\":\"\",\"payclass\":\"\"},{\"type\":\"prtasktype\"},{\"type\":\"druginfo\",\"index\":\"121\",\"reciptypecode\":\"\",\"reciptypecodeex\":\"\",\"duration\":\"\",\"executivedept\":\"\",\"dosetype\":0,\"skintest\":-1,\"firstdayfreq\":\"-1\",\"enddayfreq\":\"\",\"driptime\":\"\",\"driprange\":\"\",\"driprate\":\"\",\"ischronicdisease\":-1,\"pharmacycode\":\"XYF7\",\"medinsurcode\":\"\",\"pharmacyname\":\"西药房7\",\"medinsurname\":\"\",\"payclass\":-1,\"doctorpriv\":-1,\"decoction\":\"\"}]}}";

        //String b =Pattern.compile("^hiscode(.*)").matcher("hiscode00001").group(0);
        Matcher matcher = Pattern.compile("\"HospID\":\"(\\S+)\",\"HospName\"").matcher(inputJsonStr);
        if (matcher.find()){
           String a = matcher.group(1);
            System.out.println(a);
        }

    }

}
