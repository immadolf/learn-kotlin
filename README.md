# learn-kotlin

### course
https://www.bilibili.com/video/BV1rE411k7Xe

### resources(值得一读的文章)：
- https://developer.android.google.cn/codelabs/java-to-kotlin#0
- https://www.kotlincn.net/docs/reference/coding-conventions.html
- https://droidyue.com/blog/2019/05/19/do-and-dont-in-kotlin/

### question（记录一下学习中遇到的问题）
1. runBlocking的doc说会阻塞线程，但是阻塞的时候这个线程还可以去执行别的协程，这还叫阻塞吗？
2. Accessing the thread-local without corresponding context element leads to undefined value，不理解这个例子和其他例子有什么区别？
3. Flow中使用buffer，具体是减少了哪部分的时间开销？