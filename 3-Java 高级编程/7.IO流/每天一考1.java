/*
	1. 说明流的三种分类方式

		操作数据单位：字节流、字符流

		数据流向：输入流、输出流

		流的角色：节点流、处理流

	2. 写出 4 个 IO 流中的抽象基类，4 个文件流， 4 个缓冲流

		InputStream 		FileInputStream			BufferedInputStream

		OutputStream 		FileOutputStream		BufferedOutputStream

		Reader 				FileReader				BufferReader

		Writer 				FileWriter				BufferWriter


		RandomAccessFile

	3. 字节流与字符流的区别与使用情境

        对于文本文件(.txt，.java，.c，.cpp)，使用字符流处理

        对于非文本文件(.jpg，.mp3，.mp4，.avi，.doc，.ppt，...)，使用字节流处理

    4. 使用缓冲流实现 a.jpg 文件复制为 b.jpg 文件的操作

    	BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.jpg"));
    	BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("b.jpg"));

    	byte[] buffer = new byte[1024];
		int len;

		while((len = bis.read(buffer)) != -1){
			bos.write(buffer, 0, len);
		}

		bos.close;
		bis.close;

		// 此时的异常需要使用 try-catch-finally 处理

	5. 转换流是哪两个类，分别的作用是什么？请分别创建两个类的是对象

		InputStreamReader：输入的字节流转换为输入的字符流 解码

		OutputStreamWriter：输出的字符流转换为输出的字节流 编码

		InputStreamReader isr = new InpurStreamReader(new FileInputStream("..."), "utf-8");
		OutputStreamWriter isr = new OutputStreamWriter(new FileOutputStream("..."), "gbk");

*/