// mark mckelvy

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.datatransfer.*;

public class Converter extends JApplet {

    String in, out;
    String aspace = " ";
    String space = "00100000";
    String exclamation = "00100001";
    String dquote = "00100010";
    String pound = "00100011";
    String dollar = "00100100";
    String percent = "00100101";
    String ampersand = "00100110";
    String squote = "00100111";
    String lparen = "00101000";
    String rparen = "00101001";
    String asterisk = "00101010";
    String plus = "00101011";
    String comma = "00101100";
    String minus = "00101101";
    String period = "00101110";
    String fslash = "00101111";
    String bslash = "01011100";
    String zero = "00110000";
    String one = "00110001";
    String two = "00110010";
    String three = "00110011";
    String four = "00110100";
    String five = "00110101";
    String six = "00110110";
    String seven = "00110111";
    String eight = "00111000";
    String nine = "00111001";
    String colon = "00111010";
    String semicolon = "00111011";
    String lessthan = "00111100";
    String equals = "00111101";
    String greaterthan = "00111110";
    String question = "00111111";
    String lbracket = "01011011";
    String rbracket = "01011101";
    String caret = "01011110";
    String underscore = "01011111";
    String bquote = "01100000";
    String at = "01000000";
    String lbrace = "01111011";
    String vbar = "01111100";
    String rbrace = "01111101";
    String tilde = "01111110";
    String delta = "01111111";
    String A = "01000001";
    String B = "01000010";
    String C = "01000011";
    String D = "01000100";
    String E = "01000101";
    String F = "01000110";
    String G = "01000111";
    String H = "01001000";
    String I = "01001001";
    String J = "01001010";
    String K = "01001011";
    String L = "01001100";
    String M = "01001101";
    String N = "01001110";
    String O = "01001111";
    String P = "01010000";
    String Q = "01010001";
    String R = "01010010";
    String S = "01010011";
    String T = "01010100";
    String U = "01010101";
    String V = "01010110";
    String W = "01010111";
    String X = "01011000";
    String Y = "01011001";
    String Z = "01011010";
    String a = "01100001";
    String b = "01100010";
    String c = "01100011";
    String d = "01100100";
    String e = "01100101";
    String f = "01100110";
    String g = "01100111";
    String h = "01101000";
    String i = "01101001";
    String j = "01101010";
    String k = "01101011";
    String l = "01101100";
    String m = "01101101";
    String n = "01101110";
    String o = "01101111";
    String p = "01110000";
    String q = "01110001";
    String r = "01110010";
    String s = "01110011";
    String t = "01110100";
    String u = "01110101";
    String v = "01110110";
    String w = "01110111";
    String x = "01111000";
    String y = "01111001";
    String z = "01111010";
    JButton toBinary, toASCII, clear;
    JTextArea input, output;
    Font theFont;
    GridBagLayout layout;
    GridBagConstraints constraints;

    JMenuBar themenu;
    JMenu file, edit, convert, edit_fcolor1, edit_fcolor2, edit_bcolor1, edit_bcolor2;
    JMenuItem file_clear, convert_ascii, convert_binary, convert_letters;

    public void init() {
        toBinary = new JButton("To Binary");
        toASCII = new JButton("To ASCII");
        clear = new JButton("Clear");
        input = new JTextArea();
        output = new JTextArea();
        themenu = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        edit_fcolor1 = new JMenu("Foreground Box 1");
        edit_fcolor2 = new JMenu("Foreground Box 2");
        edit_bcolor1 = new JMenu("Background Box 1");
        edit_bcolor2 = new JMenu("Background Box 2");
        file_clear = new JMenuItem("Clear");
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        theFont = new Font("Comic Sans MS", Font.BOLD, 12);
        toBinary.setFont(theFont);
        toASCII.setFont(theFont);
        clear.setFont(theFont);
        theFont = new Font("Comic Sans MS", Font.PLAIN, 11);
        input.setLineWrap(true);
        input.setTabSize(4);
        input.setWrapStyleWord(true);
        input.setFont(theFont);
        input.setBackground(Color.yellow);
        input.setRows(8);
        output.setLineWrap(true);
        output.setTabSize(4);
        output.setWrapStyleWord(true);
        output.setFont(theFont);
        output.setRows(16);
        file.add(file_clear);
        file.addSeparator();
        themenu.add(file);
        themenu.add(edit);
        themenu.setBorderPainted(true);
        this.setJMenuBar(themenu);
        this.getContentPane().setLayout(layout);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        layout.setConstraints(input, constraints);
        this.getContentPane().add(input);
        constraints.gridy = 1;
        layout.setConstraints(output, constraints);
        this.getContentPane().add(output);
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        layout.setConstraints(toBinary, constraints);
        this.getContentPane().add(toBinary);
        constraints.gridx = 1;
        constraints.gridwidth = 1;
        layout.setConstraints(toASCII, constraints);
        this.getContentPane().add(toASCII);
        constraints.gridx = 2;
        constraints.gridwidth = GridBagConstraints.RELATIVE;
        layout.setConstraints(clear, constraints);
        this.getContentPane().add(clear);
        toBinary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == toBinary) {
                    //toBin();
                }
            }
        });
        convert_binary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == convert_binary) {
                    //this.toBin();
                }
            }
        });
        toASCII.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == toASCII) {
                    //this.toASC();
                }
            }
        });
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == clear) {
                    input.setText("");
                    output.setText("");
                    output.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
                    output.setForeground(Color.black);
                    output.setBackground(Color.white);
                }
            }
        });
        file_clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == file_clear) {
                    input.setText("");
                    output.setText("");
                    output.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
                    output.setForeground(Color.black);
                    output.setBackground(Color.white);
                }
            }
        });

    }

    class Helper {
        public void toASC() {
            boolean error = false;
            int counter;
            String temp = "";

            in = input.getText();
            out = "";
            output.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
            output.setForeground(Color.black);
            output.setBackground(Color.white);

            for (counter = 0; counter < (in.length()); counter++) {
                if ((in.charAt(counter) != '0') && (in.charAt(counter) != '1')) {
                    error = true;
                } else {
                    error = false;
                }
            }
            if (error) {
                output.setForeground(Color.red);
                output.setBackground(Color.black);
                output.setFont(new Font("Times New Roman", Font.BOLD, 15));
                output.setText("\n\n\n\n\n\n\nCharacters other than '1' & '0' are not allowed!");
            }
            if (!error) {
                for (counter = 0; counter < (in.length()); counter++) {
                    temp += in.charAt(counter);
                    if ((temp.length() / 8) == 1) {
                        if (temp.equals(space))
                            out += " ";
                        else if (temp.equals(exclamation))
                            out += "!";
                        else if (temp.equals(dquote))
                            out += 34;
                        else if (temp.equals(pound))
                            out += "#";
                        else if (temp.equals(dollar))
                            out += "$";
                        else if (temp.equals(percent))
                            out += "%";
                        else if (temp.equals(ampersand))
                            out += "&";
                        else if (temp.equals(squote))
                            out += "'";
                        else if (temp.equals(lparen))
                            out += "(";
                        else if (temp.equals(rparen))
                            out += ")";
                        else if (temp.equals(asterisk))
                            out += "*";
                        else if (temp.equals(plus))
                            out += "+";
                        else if (temp.equals(comma))
                            out += ",";
                        else if (temp.equals(minus))
                            out += "-";
                        else if (temp.equals(period))
                            out += ".";
                        else if (temp.equals(fslash))
                            out += "/";
                        else if (temp.equals(bslash))
                            out += 92;
                        else if (temp.equals(zero))
                            out += "0";
                        else if (temp.equals(one))
                            out += "1";
                        else if (temp.equals(two))
                            out += "2";
                        else if (temp.equals(three))
                            out += "3";
                        else if (temp.equals(four))
                            out += "4";
                        else if (temp.equals(five))
                            out += "5";
                        else if (temp.equals(six))
                            out += "6";
                        else if (temp.equals(seven))
                            out += "7";
                        else if (temp.equals(eight))
                            out += "8";
                        else if (temp.equals(nine))
                            out += "9";
                        else if (temp.equals(colon))
                            out += ":";
                        else if (temp.equals(semicolon))
                            out += ";";
                        else if (temp.equals(lessthan))
                            out += "<";
                        else if (temp.equals(greaterthan))
                            out += ">";
                        else if (temp.equals(equals))
                            out += "=";
                        else if (temp.equals(question))
                            out += "?";
                        else if (temp.equals(lbracket))
                            out += "[";
                        else if (temp.equals(rbracket))
                            out += "]";
                        else if (temp.equals(caret))
                            out += "^";
                        else if (temp.equals(underscore))
                            out += "_";
                        else if (temp.equals(bquote))
                            out += "`";
                        else if (temp.equals(at))
                            out += "@";
                        else if (temp.equals(lbrace))
                            out += "{";
                        else if (temp.equals(vbar))
                            out += "|";
                        else if (temp.equals(rbrace))
                            out += "}";
                        else if (temp.equals(tilde))
                            out += "~";
                        else if (temp.equals(A))
                            out += "A";
                        else if (temp.equals(B))
                            out += "B";
                        else if (temp.equals(C))
                            out += "C";
                        else if (temp.equals(D))
                            out += "D";
                        else if (temp.equals(E))
                            out += "E";
                        else if (temp.equals(F))
                            out += "F";
                        else if (temp.equals(G))
                            out += "G";
                        else if (temp.equals(H))
                            out += "H";
                        else if (temp.equals(I))
                            out += "I";
                        else if (temp.equals(J))
                            out += "J";
                        else if (temp.equals(K))
                            out += "K";
                        else if (temp.equals(L))
                            out += "L";
                        else if (temp.equals(M))
                            out += "M";
                        else if (temp.equals(N))
                            out += "N";
                        else if (temp.equals(O))
                            out += "O";
                        else if (temp.equals(P))
                            out += "P";
                        else if (temp.equals(Q))
                            out += "Q";
                        else if (temp.equals(R))
                            out += "R";
                        else if (temp.equals(S))
                            out += "S";
                        else if (temp.equals(T))
                            out += "T";
                        else if (temp.equals(U))
                            out += "U";
                        else if (temp.equals(V))
                            out += "V";
                        else if (temp.equals(W))
                            out += "W";
                        else if (temp.equals(X))
                            out += "X";
                        else if (temp.equals(Y))
                            out += "Y";
                        else if (temp.equals(Z))
                            out += "Z";
                        else if (temp.equals(a))
                            out += "a";
                        else if (temp.equals(b))
                            out += "b";
                        else if (temp.equals(c))
                            out += "c";
                        else if (temp.equals(d))
                            out += "d";
                        else if (temp.equals("01100101"))
                            out += "e";
                        else if (temp.equals(f))
                            out += "f";
                        else if (temp.equals(g))
                            out += "g";
                        else if (temp.equals(h))
                            out += "h";
                        else if (temp.equals(i))
                            out += "i";
                        else if (temp.equals(j))
                            out += "j";
                        else if (temp.equals(k))
                            out += "k";
                        else if (temp.equals(l))
                            out += "l";
                        else if (temp.equals(m))
                            out += "m";
                        else if (temp.equals(n))
                            out += "n";
                        else if (temp.equals(o))
                            out += "o";
                        else if (temp.equals(p))
                            out += "p";
                        else if (temp.equals(q))
                            out += "q";
                        else if (temp.equals(r))
                            out += "r";
                        else if (temp.equals(s))
                            out += "s";
                        else if (temp.equals(t))
                            out += "t";
                        else if (temp.equals(u))
                            out += "u";
                        else if (temp.equals(v))
                            out += "v";
                        else if (temp.equals(w))
                            out += "w";
                        else if (temp.equals(x))
                            out += "x";
                        else if (temp.equals(y))
                            out += "y";
                        else if (temp.equals(z))
                            out += "z";
                        temp = "";
                    }
                }
                output.setText(out);
            }
        }

        public void toBin() {
            in = input.getText();
            out = "";
            output.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
            output.setForeground(Color.black);
            output.setBackground(Color.white);

            for (int counter = 0; counter < (in.length()); counter++) {
                switch (in.charAt(counter)) {
                    case ' ':
                        out += space;
                        break;
                    case '!':
                        out += exclamation;
                        break;
                    case '"':
                        out += dquote;
                        break;
                    case '#':
                        out += pound;
                        break;
                    case '$':
                        out += dollar;
                        break;
                    case '%':
                        out += percent;
                        break;
                    case '&':
                        out += ampersand;
                        break;
                    case 39:
                        out += squote;
                        break;
                    case '(':
                        out += lparen;
                        break;
                    case ')':
                        out += rparen;
                        break;
                    case '*':
                        out += asterisk;
                        break;
                    case '+':
                        out += plus;
                        break;
                    case ',':
                        out += comma;
                        break;
                    case '-':
                        out += minus;
                        break;
                    case '.':
                        out += period;
                        break;
                    case '/':
                        out += fslash;
                        break;
                    case 92:
                        out += bslash;
                        break;
                    case '0':
                        out += zero;
                        break;
                    case '1':
                        out += one;
                        break;
                    case '2':
                        out += two;
                        break;
                    case '3':
                        out += three;
                        break;
                    case '4':
                        out += four;
                        break;
                    case '5':
                        out += five;
                        break;
                    case '6':
                        out += six;
                        break;
                    case '7':
                        out += seven;
                        break;
                    case '8':
                        out += eight;
                        break;
                    case '9':
                        out += nine;
                        break;
                    case ':':
                        out += colon;
                        break;
                    case ';':
                        out += semicolon;
                        break;
                    case '<':
                        out += lessthan;
                        break;
                    case '>':
                        out += greaterthan;
                        break;
                    case '=':
                        out += equals;
                        break;
                    case '?':
                        out += question;
                        break;
                    case '[':
                        out += lbracket;
                        break;
                    case ']':
                        out += rbracket;
                        break;
                    case '^':
                        out += caret;
                        break;
                    case '_':
                        out += underscore;
                        break;
                    case '`':
                        out += bquote;
                        break;
                    case '@':
                        out += at;
                        break;
                    case '{':
                        out += lbrace;
                        break;
                    case '|':
                        out += vbar;
                        break;
                    case '}':
                        out += rbrace;
                        break;
                    case '~':
                        out += tilde;
                        break;
                    case 'A':
                        out += A;
                        break;
                    case 'B':
                        out += B;
                        break;
                    case 'C':
                        out += C;
                        break;
                    case 'D':
                        out += D;
                        break;
                    case 'E':
                        out += E;
                        break;
                    case 'F':
                        out += F;
                        break;
                    case 'G':
                        out += G;
                        break;
                    case 'H':
                        out += H;
                        break;
                    case 'I':
                        out += I;
                        break;
                    case 'J':
                        out += J;
                        break;
                    case 'K':
                        out += K;
                        break;
                    case 'L':
                        out += L;
                        break;
                    case 'M':
                        out += M;
                        break;
                    case 'N':
                        out += N;
                        break;
                    case 'O':
                        out += O;
                        break;
                    case 'P':
                        out += P;
                        break;
                    case 'Q':
                        out += Q;
                        break;
                    case 'R':
                        out += R;
                        break;
                    case 'S':
                        out += S;
                        break;
                    case 'T':
                        out += T;
                        break;
                    case 'U':
                        out += U;
                        break;
                    case 'V':
                        out += V;
                        break;
                    case 'W':
                        out += W;
                        break;
                    case 'X':
                        out += X;
                        break;
                    case 'Y':
                        out += Y;
                        break;
                    case 'Z':
                        out += Z;
                        break;
                    case 'a':
                        out += a;
                        break;
                    case 'b':
                        out += b;
                        break;
                    case 'c':
                        out += c;
                        break;
                    case 'd':
                        out += d;
                        break;
                    case 'e':
                        out += "01100101";//e;
                        break;
                    case 'f':
                        out += f;
                        break;
                    case 'g':
                        out += g;
                        break;
                    case 'h':
                        out += h;
                        break;
                    case 'i':
                        out += i;
                        break;
                    case 'j':
                        out += j;
                        break;
                    case 'k':
                        out += k;
                        break;
                    case 'l':
                        out += l;
                        break;
                    case 'm':
                        out += m;
                        break;
                    case 'n':
                        out += n;
                        break;
                    case 'o':
                        out += o;
                        break;
                    case 'p':
                        out += p;
                        break;
                    case 'q':
                        out += q;
                        break;
                    case 'r':
                        out += r;
                        break;
                    case 's':
                        out += s;
                        break;
                    case 't':
                        out += t;
                        break;
                    case 'u':
                        out += u;
                        break;
                    case 'v':
                        out += v;
                        break;
                    case 'w':
                        out += w;
                        break;
                    case 'x':
                        out += x;
                        break;
                    case 'y':
                        out += y;
                        break;
                    case 'z':
                        out += z;
                        break;
                }
            }
            output.setText(out);
        }
    }
}
