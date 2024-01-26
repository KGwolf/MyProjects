package designpatten.factory.factorymethod;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @ClassName: JsonRuleConfigParserFactory
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/23 17:00
 * @Version: V1.0
 */
public class JsonRuleConfigParserFactory{// implements IRuleConfigParserFactory
//    @Override
//    public IRuleConfigParser createParser() {
//        return new JsonRuleConfigParser();
//    }
//
//    public static void main(String[] args) {
//        //这里需要得到IRuleConfigParser,还是有一堆的if else!!!!!!
//        IRuleConfigParser parser = null;
//        if ("json".equalsIgnoreCase(configFormat)) {
//            parser = new JsonRuleConfigParserFactory().createParser();
//        } else if ("xml".equalsIgnoreCase(configFormat)) {
//            parser = new XmlRuleConfigParserFactory().createParser();
//        } else if ("yaml".equalsIgnoreCase(configFormat)) {
//            parser = new JsonRuleConfigParserFactory().createParser();
//        } else if ("properties".equalsIgnoreCase(configFormat)) {
//            parser = new PropertiesRuleConfigParserFactory().createParser();
//        }
//
//        //再引入RuleConfigParserFactoryMap
//        parser = RuleConfigParserFactoryMap.getParserFactory("json").createParser();
//    }
//
//    public  class RuleConfigParserFactoryMap{
//        private static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();
//        static {
//            cachedFactories.put("json", new JsonRuleConfigParserFactory());
//            cachedFactories.put("xml", new XmlRuleConfigParserFactory());
//            cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
//            cachedFactories.put("properties", new PropertiesRuleConfigParserFactory())
//        }
//        public static IRuleConfigParserFactory getParserFactory(String type) {
//            if (type == null || type.isEmpty()) {
//                return null;
//            }
//            IRuleConfigParserFactory parserFactory = cachedFactories.get(type.toLowerCase(Locale.ROOT);
//            return parserFactory;
//        }
//    }
}
