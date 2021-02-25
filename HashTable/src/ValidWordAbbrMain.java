public class ValidWordAbbrMain {
    public static void main(String[] args) {
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(new String[]{"deer", "door", "cake", "card"});
        System.out.println(validWordAbbr.isUnique("dear")); // 返回 false，字典中的 "deer" 与输入 "dear" 的缩写都是 "d2r"，但这两个单词不相同
        System.out.println(validWordAbbr.isUnique("cart")); // 返回 true，字典中不存在缩写为 "c2t" 的单词
        System.out.println(validWordAbbr.isUnique("cane")); // 返回 false，字典中的 "cake" 与输入 "cane" 的缩写都是 "c2e"，但这两个单词不相同
        System.out.println(validWordAbbr.isUnique("make")); // 返回 true，字典中不存在缩写为 "m2e" 的单词
        System.out.println(validWordAbbr.isUnique("cake")); // 返回 true，因为 "cake" 已经存在于字典中，并且字典中没有其他缩写为 "c2e" 的单词
    }
}
