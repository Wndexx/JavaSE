/*
	1. NIO 的使用说明：

		- Java NIO (New IO，Non-Blocking IO)是从 Java 1.4 版本开始引入的一套新的 IO API，可以替代标准的 Java IO API。

			NIO 与原来的 IO 有同样的作用和目的，但是使用的方式完全不同，NIO 支持面向缓冲区的(IO 是面向流的)、基于通道的 IO 操作。

			NIO 将以更加高效的方式进行文件的读写操作

		- 随着 JDK 7 的发布，Java 对 NIO 进行了极大的扩展，增强了对文件处理和文件系统特性的支持，以至于我们称他们为 NIO.2。

			因为 NIO 提供的一些功能，NIO 已经成为文件处理中越来越重要的部分

	2. Path 的使用 ---> jdk7 提供

		2.1 Path 的说明：

			Path 替换原有的 File 类

		2.2 如何实例化：

			Paths 类提供的静态 get() 方法用来获取 Path 对象：

				static Path get(String first, String ... more)	用于将多个字符串串连成路径

				static Path get(URI uri)						返回指定 uri 对应的 Path 路径

		2.3 常用方法：

			Path 常用方法：

				String toString()					返回调用 Path 对象的字符串表示形式

				boolean startsWith(String path)		判断是否以 path 路径开始

				boolean endsWith(String path)		判断是否以 path 路径结束

				boolean isAbsolute()				判断是否是绝对路径

				Path getParent()					返回 Path 对象包含整个路径，不包含 Path 对象指定的文件路径

				Path getRoot()						返回调用 Path 对象的根路径

				Path getFileName()					返回与调用 Path 对象关联的文件名

				int getNameCount()					返回 Path 根目录后面元素的数量

				Path getName(int idx)				返回指定索引位置 idx 的路径名称

				Path toAbsolutePath()				作为绝对路径返回调用 Path 对象

				File toFile()						将 Path 转化为 File 类的对象

	3. Files 工具类 ---> jdk 7 提供

		3.1 作用：

			操作文件或文件目录的工具类

		3.2 常用方法：
	
			Files常用方法：

				Path copy(Path src, Path dest, CopyOption ... how)				文件的复制

				Path createDirectory(Path path, FileAttribute<?> ... attr)		创建一个目录

				Path createFile(Path path, FileAttribute<?> ... arr)			创建一个文件

				void delete(Path path)											删除一个文件/目录，如果不存在，执行报错

				void deleteIfExists(Path path)									Path对应的文件/目录如果存在，执行删除

				Path move(Path src, Path dest, CopyOption...how)				将 src 移动到 dest 位置

				long size(Path path)											返回 path 指定文件的大小

			Files常用方法：用于判断

				boolean exists(Path path, LinkOption ... opts)					判断文件是否存在

				boolean isDirectory(Path path, LinkOption ... opts)				判断是否是目录

				boolean isRegularFile(Path path, LinkOption ... opts)			判断是否是文件

				boolean isHidden(Path path)										判断是否是隐藏文件

				boolean isReadable(Path path)									判断文件是否可读

				boolean isWritable(Path path)									判断文件是否可写

				boolean notExists(Path path, LinkOption ... opts)				判断文件是否不存在

			Files常用方法：用于操作内容

				SeekableByteChannel newByteChannel(Path path, OpenOption...how)	获取与指定文件的连接，how 指定打开方式。

				DirectoryStream<Path> newDirectoryStream(Path path)				打开 path 指定的目录

				InputStream newInputStream(Path path, OpenOption...how)			获取 InputStream 对象

				OutputStream newOutputStream(Path path, OpenOption...how)		获取 OutputStream 对象
*/