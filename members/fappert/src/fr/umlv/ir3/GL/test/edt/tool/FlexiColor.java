/*
 * Created on 26 déc. 2004
 * by GG
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.GL.test.edt.tool;

import java.awt.Color;

/**
 * FlexiColor - Description Belong a big number of color
 * 
 * @version Version 0.1
 * @author FlexiTeam - VF
 */
public class FlexiColor
{
    /** 
     * getColor - get a color with a String "#xxyyzz"
     * 
     *     <code>Color c = FlexiColor.get(FlexiColor.black);</code>
     *
     * @param c the color in "#xxyyzz" format
     * @return Returns the color
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public static Color getColor(String c){
        return Color.decode(c);
    }
    /** 
     * brighter - get a brighter color than the color in args
     * 
     *     <code>Color newc = FlexiColor.brighter(c);</code>
     *
     * @param c the color you want to bright
     * @return Returns the color brightered
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public static Color brighter(Color c){
        return c.brighter();
    }
    /** 
     * darker - get a darker color than the color in args
     * 
     *     <code>Color newc = FlexiColor.darker(c);</code>
     *
     * @param c the color you want to dark
     * @return Returns the color darkered
     * 
     * @author   FlexiTeam - VF
     * @date     6 janv. 2005
     */
    public static Color darker(Color c){
        return c.darker();
    }
    public final static String black = "#000000";
    public final static String navy  = "#000080";
    public final static String darkblue = "#00008b";
    public final static String mediumblue = "#0000cd";
    public final static String blue = "#0000ff";
    public final static String darkgreen = "#006400";
    public final static String green = "#008000";
    public final static String teal = "#008080";
    public final static String darkcyan = "#008b8b";
    public final static String deepskyblue = "#00bfbf";
    public final static String darkturquoise = "#00ced1";
    public final static String mediumspringgreen = "#00fa9a";
    public final static String lime = "#00ff00";
    public final static String springgreen = "#00ff7f";
    public final static String aqua = "#00ffff";
    public final static String cyan = "#00ffff";
    public final static String midnightblue = "#191970";
    public final static String dodgerblue = "#1e90ff";
    public final static String lightseagreen = "#20b2aa";
    public final static String forestgreen = "#228b22";
    public final static String seagreen = "#2e8b57";
    public final static String darkslategray = "#2f4f4f";
    public final static String limegreen = "#32cd32";
    public final static String mediumseagreen = "#3cb371";
    public final static String turquoise = "#40e0d0";
    public final static String royalblue = "#4169e1";
    public final static String steelblue = "#4682b4";
    public final static String darkslateblue = "#483d8b";
    public final static String mediumturquoise = "#48d1cc";
    public final static String indigo = "#4b0082";
    public final static String darkolivegreen = "#556b2f";
    public final static String cadetblue = "#5f9ea0";
    public final static String cornflowerblue = "#6495ed";
    public final static String mediumaquamarine = "#66cdaa";
    public final static String dimgray = "#696969";
    public final static String slateblue = "#6a5acd";
    public final static String olivedrab = "#6b8e23";
    public final static String slategray = "#708090";
    public final static String lightslategray = "#778899";
    public final static String mediumslateblue = "#7b68ee";
    public final static String lawngreen = "#7cfc00";
    public final static String chartreuse = "#7fff00";
    public final static String aquamarine = "#7fffd4";
    public final static String maroon = "#800000";
    public final static String purple = "#800080";
    public final static String olive = "#808000";
    public final static String gray = "#808080";
    public final static String skyblue = "#87ceeb";
    public final static String lightskyblue = "#87cefa";
    public final static String blueviolet = "#8a2be2";
    public final static String darkred = "#8b0000";
    public final static String darkmagenta = "#8b008b";
    public final static String saddlebrown = "#8b4513";
    public final static String darkseagreen = "#8fbc8f";
    public final static String lightgreen = "#90ee90";
    public final static String mediumpurple = "#9370db";
    public final static String darkviolet = "#9400d3";
    public final static String palegreen = "#98fb98";
    public final static String darkorchid = "#9932cc";
    public final static String yellowgreen = "#9acd32";
    public final static String sienna = "#a0522d";
    public final static String brown = "#a52a2a";
    public final static String darkgray = "#a9a9a9";
    public final static String lightblue = "#add8e6";
    public final static String greenyellow = "#adff2f";
    public final static String paleturquoise = "#afeeee";
    public final static String lightsteelblue = "#b0c4de";
    public final static String powderblue = "#b0e0e6";
    public final static String firebrick = "#b22222";
    public final static String darkgoldenrod = "#b8860b";
    public final static String mediumorchid = "#ba55d3";
    public final static String rosybrown = "#bc8f8f";
    public final static String darkkhaki = "#bdb76b";
    public final static String silver = "#c0c0c0";
    public final static String mediumvioletred = "#c71585";
    public final static String indianred = "#cd5c5c";
    public final static String peru = "#cd853f";
    public final static String chocolate = "#d2691e";
    public final static String tan = "#d2b48c";
    public final static String lightgray = "#d3d3d3";
    public final static String thistle = "#d8bfd8";
    public final static String orchid = "#da70d6";
    public final static String goldenrod = "#daa520";
    public final static String palevioletred = "#db7093";
    public final static String crimson = "#dc143c";
    public final static String gainsboro = "#dcdcdc";
    public final static String plum = "#dda0dd";
    public final static String burlywood = "#deb887";
    public final static String lightcyan = "#e0ffff";
    public final static String lavender = "#e6e6fa";
    public final static String darksalmon = "#e9967a";
    public final static String violet = "#ee82ee";
    public final static String palegoldenrod = "#eee8aa";
    public final static String lightcoral = "#f08080";
    public final static String khaki = "#f0e68c";
    public final static String aliceblue = "#f0f8ff";
    public final static String honeydew = "#f0fff0";
    public final static String azure = "#f0ffff";
    public final static String sandybrown = "#f4a460";
    public final static String wheat = "#f5deb3";
    public final static String beige = "#f5f5dc";
    public final static String whitesmoke = "#f5f5f5";
    public final static String mintcream = "#f5fffa";
    public final static String ghostwhite = "#f8f8ff";
    public final static String salmon = "#fa8072";
    public final static String antiquewhite = "#faebd7";
    public final static String linen = "#faf0e6";
    public final static String lightgoldenrodyellow = "#fafad2";
    public final static String oldlace = "#fdf5e6";
    public final static String red = "#ff0000";
    public final static String fuchsia = "#ff00ff";
    public final static String magenta = "#ff00ff";
    public final static String deeppink = "#ff1493";
    public final static String orangered = "#ff4500";
    public final static String tomato = "#ff6347";
    public final static String hotpink = "#ff69b4";
    public final static String coral = "#ff7f50";
    public final static String darkorange = "#ff8c00";
    public final static String lightsalmon = "#ffa07a";
    public final static String orange = "#ffa500";
    public final static String lightpink = "#ffb6c1";
    public final static String pink = "#ffc0cb";
    public final static String gold = "#ffd700";
    public final static String peachpuff = "#ffdab9";
    public final static String navajowhite = "#ffdead";
    public final static String moccasin = "#ffe4b5";
    public final static String bisque = "#ffe4c4";
    public final static String mistyrose = "#ffe4e1";
    public final static String blanchedalmond = "#ffebcd";
    public final static String papayawhip = "#ffefd5";
    public final static String lavenderblush = "#fff0f5";
    public final static String seashell = "#fff5ee";
    public final static String cornsilk = "#fff8dc";
    public final static String lemonchiffon = "#fffacd";
    public final static String floralwhite = "#fffaf0";
    public final static String snow = "#fffafa";
    public final static String yellow = "#ffff00";
    public final static String lightyellow = "#ffffe0";
    public final static String ivory = "#fffff0";
    public final static String white = "#ffffff";
}