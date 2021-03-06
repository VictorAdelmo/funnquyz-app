????   3 ? groovy/util/CharsetToolkit  java/lang/Object  CharsetToolkit.java EMPTY_CHARSET_ARRAY [Ljava/nio/charset/Charset; buffer [B defaultCharset Ljava/nio/charset/Charset; charset enforce8Bit Z file Ljava/io/File; EMPTY_BYTE_ARRAY <init> (Ljava/io/File;)V java/io/IOException  java/lang/Throwable  ()V  
    	    	   getDefaultSystemCharset ()Ljava/nio/charset/Charset;   
  ! 
 	  #  	  % java/io/FileInputStream '  
 ( ) java/io/InputStream + read ([B)I - .
 , /  		  1  		  3 java/io/File 5 	 java/lang/System 8 	arraycopy *(Ljava/lang/Object;ILjava/lang/Object;II)V : ;
 9 < close > 
 , ? addSuppressed (Ljava/lang/Throwable;)V A B
  C bytesToGuess bytes 	bytesRead I input Ljava/io/InputStream; this Lgroovy/util/CharsetToolkit; setDefaultCharset (Ljava/nio/charset/Charset;)V 
getCharset guessEncoding P  
  Q setEnforce8Bit (Z)V enforce getEnforce8Bit ()Z getDefaultCharset 
hasUTF8Bom Y W
  Z UTF-8 \ java/nio/charset/Charset ^ forName .(Ljava/lang/String;)Ljava/nio/charset/Charset; ` a
 _ b hasUTF16LEBom d W
  e UTF-16LE g hasUTF16BEBom i W
  j UTF-16BE l isTwoBytesSequence (B)Z n o
  p isContinuationChar r o
  s isThreeBytesSequence u o
  v isFourBytesSequence x o
  y isFiveBytesSequence { o
  | isSixBytesSequence ~ o
   US-ASCII ? b0 B b1 b2 b3 b4 b5 highOrderBit validU8Char length i b file.encoding ? getProperty &(Ljava/lang/String;)Ljava/lang/String; ? ?
 9 ? 	getReader ()Ljava/io/BufferedReader; java/io/FileNotFoundException ? java/io/LineNumberReader ? java/io/InputStreamReader ? O  
  ? 2(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V  ?
 ? ? (Ljava/io/Reader;)V  ?
 ? ? ()I - ?
 ? ? reader Ljava/io/LineNumberReader; getAvailableCharsets ()[Ljava/nio/charset/Charset; availableCharsets ()Ljava/util/SortedMap; ? ?
 _ ? java/util/SortedMap ? values ()Ljava/util/Collection; ? ? ? ?  	  ? java/util/Collection ? toArray (([Ljava/lang/Object;)[Ljava/lang/Object; ? ? ? ?  
collection Ljava/util/Collection; <clinit> Co