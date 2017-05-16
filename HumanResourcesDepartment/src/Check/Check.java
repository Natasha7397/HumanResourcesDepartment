/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Check;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Acer
 */
public class Check extends DocumentFilter {

    private int limit;

    public Check(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit can not be <= 0");
        }
        this.limit = limit;
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text,
            AttributeSet attrs) throws BadLocationException {
        int currentLength = fb.getDocument().getLength();
        int overLimit = (currentLength + text.length()) - limit - length;
        if (overLimit > 0) {
            text = text.substring(0, text.length() - overLimit);
        }
        if (text.length() > 0) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

}
