package sozluk;

import java.util.ArrayList;
import java.util.List;

class Agac {
    private Dugum root;

    public Agac() {
        root = new Dugum('#');
    } //ağacın ana kökü # olarak tanımlandı

    public void insert(String word) {
        if (search(word) == true)
            return;

        Dugum mevcut = root;
        Dugum onceki;
        for (char ch : word.toCharArray()) {
            onceki = mevcut;
            Dugum child = mevcut.getChild(ch);
            if (child != null) {
                mevcut = child;
                child.parent = onceki;
            } else {
                mevcut.children.add(new Dugum(ch));
                mevcut = mevcut.getChild(ch);
                mevcut.parent = onceki;
            }
        }
        mevcut.word = true;
    }

    public boolean search(String word) {
        Dugum mevcut = root;
        for (char ch : word.toCharArray()) {
            if (mevcut.getChild(ch) == null)
                return false;
            else {
                mevcut = mevcut.getChild(ch);
            }
        }
        if (mevcut.word == true) {
            return true;
        }
        return false;
    }

    public List<String> autocomplete(String prefix) {
        Dugum lastNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getChild(prefix.charAt(i));
            if (lastNode == null)
                return new ArrayList<>();
        }

        return lastNode.getWords();
    }
}
