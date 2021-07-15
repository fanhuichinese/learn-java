1. 实现的接口
    1. java.io.Serializable
    2. Comparable<String>
    3. CharSequence
2. 属性
    1. private final char value[];
    2. private int hash;
    3. private static final long serialVersionUID = -6849794470754667710L;
    4. private static final ObjectStreamField[] serialPersistentFields = new ObjectStreamField[0];
    5. public static final Comparator<String> CASE_INSENSITIVE_ORDER = new CaseInsensitiveComparator();
3. 内部类
    1. private static class CaseInsensitiveComparator implements Comparator<String>, java.io.Serializable
        1. 属性
            1. private static final long serialVersionUID = 8575799808933029326L;
        2. 方法
            1. public int compare(String s1, String s2)：依次比较s1 和 s2的相同位置的字符，如果发现不同，就返回这两个字符的差值，s1的字符 - s1的字符，如果将字符少的字符串比较完后都相同，就返回 s1.length - s2.length
            2. private Object readResolve()：返回 CASE_INSENSITIVE_ORDER
4. 构造器
    1. public String() { this.value = "".value; }
    2. public String(String original) { this.value = original.value; this.hash = original.hash; }
    3. public String(char value[]) { this.value = Arrays.copyOf(value, value.length); }
    4. public String(char value[], int offset, int count) { /** 判断越界 */ this.value = Arrays.copyOfRange(value, offset, offset+count); }
    5. public String(int[] codePoints, int offset, int count) { /** 类似于上面的构造器，除了判断越界，还判断数组中的整数是否是合法的字符，最后数组的元素数量还可能会大于count */ }