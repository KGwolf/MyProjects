///**
// * @ClassName: DuoTai
// * @Description: 这个案例只看多态，不看其它的。
// * @Author: xiahaitao
// * @Date: 2024/1/15 17:15
// * @Version: V1.0
// */
//public interface PrAudit {
//    public void audit(String json);
//}
//
//public class ClinicAudit implements PrAudit {
//    @Override
//    public void audit(String json) {
//        System.out.println("门诊审核："+json);
//    }
//}
//
//public class InHospAudit implements PrAudit {
//    @Override
//    public void audit(String json) {
//        System.out.println("住院审核："+json);
//    }
//}
//public class MdcDoCheck(){
//
//   public static void check(PrAudit audit, String json){
//       audit.audit(json);
//   }
//
//    public static void main(String[] args) {
//        PrAudit audit = null;
//       if ("门诊".equals("门诊")){
//           audit = new ClinicAudit();
//       }else if ("住院".equals("住院")){
//           audit = new InHospAudit();
//       }
//        check(audit,"jsonstr");
//    }
//}
