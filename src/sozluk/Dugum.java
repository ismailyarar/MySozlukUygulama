package sozluk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Dugum {
    char data;
    LinkedList<Dugum> children;
    Dugum parent;
    boolean word;

    public Dugum(char c) {
        data = c;
        children = new LinkedList<>();
        word = false;
    }

    public Dugum getChild(char c) {
        if (children != null)
            for (Dugum eachChild : children)
                if (eachChild.data == c)
                    return eachChild;
        return null;
    }

    protected List<String> getWords() {
        List<String> list = new ArrayList<>();
        if (word) {
            list.add(toString());
        }

        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                if (children.get(i) != null) {
                    list.addAll(children.get(i).getWords());
                }
            }
        }
        return list;
    }

    public String toString() {
        if (parent == null) {
            return "";
        } else {
            return parent.toString() + new String(new char[]{data});
        }
    }
}