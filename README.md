# LemonHello4Android
妈妈说，问人问题要先说你好，那么咱这个全平台的理论上做的最牛逼的对话框（只是理论上）就叫LemonHello吧~
完全可以自定义的UI，内置多种主题提示框。

> 作者：1em0nsOft - LiuRi
>
> 版本号：1.0.1
>
> 简介：这是一个完全Made in China的炫酷弹出指示层Android版本（-_-#意思就是还有iOS的），他能让你快速的自定义任何样式的弹出框。
>
> **意见建议反馈QQ群：370157608 （还寻思啥呢，赶紧加啊！）**



![效果图](https://raw.githubusercontent.com/1em0nsOft/LemonHello4Android/master/Resource/LemonHello.gif)



- 怎么样，别光看，我们不妨试试看哦！把LemonHello集成到你的项目中很简单，使用Gradle，首先在你的Project build.gradle文件中（allprojects ->repositories节点）加入如下代码：

```
allprojects {
    repositories {
        jcenter()
        // 加入下面这行
        maven { url 'https://jitpack.io' }
    }
}
```

接下来，在你的项目中的Module（xxx e.g:app） build.gradle中（dependencies节点）加入如下代码：

```
dependencies {
    // ...  你的其他依赖
    // 然后加入下面这行
    compile 'com.github.1em0nsOft:LemonHello4Android:1.0.1'
}
```

最后重新build一下就可以啦。

接下来，我们验证一下我们是否集成成功，随便找一个Activity，在onCreate方法里面我们加上如下一段代码来弹出一个对话框试试：

```
LemonHello.getSuccessHello("提示", "恭喜您，集成成功！")
      .addAction(new LemonHelloAction("我知道啦", new LemonHelloActionDelegate() {
           @Override
           public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                 helloView.hide();
           }
       }))
       .show(MainActivity.this);
```

运行一下，你就可以看到你使用LemonHello弹出的第一个对话框咯~集成成功！

![集成成功截图](https://raw.githubusercontent.com/1em0nsOft/LemonHello4Android/master/Resource/LemonHelloTest01.png)

LemonBubble默认带了四中样式，就如我们开头展示的动画里面的前四种，不过呢，你可以自定义其他样式，都可以自定义什么属性呢？给大家列一个列表：

```
// 对话框控件的宽度
width;
    
// 对话框控件的圆角半径
cornerRadius;

// 对话框面板的背景颜色
panelBackgroundColor;
    
// 对话框面板的背景Drawable
panelBackgroundDrawable;

// 对话框的背景蒙版颜色
maskColor;

// 对话框的图标绘制上下文
// 如果icon属性为空，那么会调用该属性iconPaintContext绘制
// 如果iconPaintContext为空，那么会认为无图标
iconPaintContext;

// 图标动画是否需要重复
isIconAnimationRepeat;

// 动画的执行的所需时长
animationTime;

// 对话框的图标对象
// 如果该对象为空，那么会调用iconPaintContext绘制
// 如果iconPaintContext为空，那么会认为无图标
icon;

// 图标的宽度
// 图标为正方形，因此宽度也就是高度
iconWidth;

// 图标的位置描述属性
iconLocation;

// 对话框的标题，如果该属性为null或空字符串，那么认为其没有标题
title;

// 对话框的正文内容文字
content;

// 标题文字的颜色
titleColor;

// 对话框正文内容文字颜色
contentColor;

// 标题文字的字体大小
titleFontSize;

// 对话对征文内容文字字体大小
contentFontSize;

// 标题的按钮文字大小
buttonFontSize;

// 控件的内边距
padding;

// 控件的间隙
space;

// action按钮的高度
actionLineHeight;

// 对话框的动画list（按钮说明信息list）
actions

// 第一行的按钮数量
// 如果超过这个数量，那么每一个Action都会被放到单独的行中
// 如果该数值设置为<1的数字，那么认为该值为1
firstLineButtonCount;

// 是否显示状态栏
isShowStatusBar;

// 状态栏的颜色
statusBarColor;
    
// LemonHello的事件代理
eventDelegate;

// 是否使用消息队列，若您使用了消息队列，那么后通知显示的消息框会在前一个消息框关闭后再显示
useMessageQueue
```



- 怎么样，够你用吗？我屮艸芔茻，**还不够吗？那你赶紧告诉我，还需要什么场景，我给你加上！！！！**

### LemonBubble是一款纯国产、开源、且有售后的提示框控件！有bug，我来改！有需求，我来加！你负责用就行~  对了，你还有个职责，别忘了点一个star~ 



### **我的废话说完了，你也是不是该来体验一下啦！**