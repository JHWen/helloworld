# helloworld
Android practice of ByteDance training in BIT

### day 01

#### 控件交互设计

使用的控件有TextView、ImageView、SeekBar、Switch、Button.

##### 1.seekBar 可拖动进度条

onProgressChanged 进度条改变事件 

交互逻辑：修改TextView,显示进度条的当前值，如50%

onStartTrackingTouch 按住SeekBar事件

交互逻辑：通过Toast显示简短的提示信息,如按住SeekBar

onStopTrackingTouch 松开SeekBar事件

交互逻辑：通过Toast显示简短的提示信息，如松开SeekBar

##### 2.Switch 开关

onCheckedChanged 开关变化事件，需要进一步判断开关的状态

交互逻辑：切换日间/夜间模式

设置夜间模式，通过修改AppTheme来实现，需要调用recreate()方法（存在闪屏问题），重建Activity过程中会触发onCheckedChanged事件，需要在判断逻辑中调用isPressed()方法来判断是否是人为点击操作。

##### 3.Button

onClick 按钮点击时间

交互逻辑： 点击按钮，修改TextView中的文字为“Waht a wonderful world!”

##### 4.TextView

供其他触发事件显示信息

5.ImageView

显示北理工Logo

#### App Activity显示效果：


<p align="center">
    <img src="https://s2.ax1x.com/2019/01/18/k9BkeU.png" alt="Sample"  width="300" height="500">
    <p align="center">
        <em>App Demo</em>
    </p>
</p>


####具体的交互动画录制如下：

<p align="center">
    <img src="https://s2.ax1x.com/2019/01/18/k9DJBT.gif" alt="Sample"  width="300" height="500">
    <p align="center">
        <em>App Demo Gif</em>
    </p>
</p>

日志功能打印触发事件信息(日志级别为Debug)，通过筛选功能显示指定的信息,如下所示：

```
2019-01-18 20:54:07.362 32767-32767/com.example.codesky.helloworld D/MainActivity: trigger button listener
2019-01-18 20:54:11.629 32767-32767/com.example.codesky.helloworld D/MainActivity: seekBar onStartTrackingTouch event
2019-01-18 20:54:11.642 32767-32767/com.example.codesky.helloworld D/MainActivity: seekBar onProgressChanged event
2019-01-18 20:54:11.763 32767-32767/com.example.codesky.helloworld D/MainActivity: seekBar onProgressChanged event
2019-01-18 20:54:11.778 32767-32767/com.example.codesky.helloworld D/MainActivity: seekBar onProgressChanged event
2019-01-18 20:54:11.811 32767-32767/com.example.codesky.helloworld D/MainActivity: seekBar onProgressChanged event
2019-01-18 20:54:12.025 32767-32767/com.example.codesky.helloworld D/MainActivity: seekBar onProgressChanged event
2019-01-18 20:54:12.586 32767-32767/com.example.codesky.helloworld D/MainActivity: seekBar onStopTrackingTouch event
2019-01-18 20:54:22.745 32767-32767/com.example.codesky.helloworld D/MainActivity: Switch Checked 夜间模式
2019-01-18 20:54:22.789 32767-497/com.example.codesky.helloworld I/ContentCatcher: Interceptor : Catcher list invalid for com.example.codesky.helloworld@com.example.codesky.helloworld.MainActivity@220794545
2019-01-18 20:54:22.845 32767-32767/com.example.codesky.helloworld D/MainActivity: seekBar onProgressChanged event
2019-01-18 20:54:24.329 32767-32767/com.example.codesky.helloworld D/MainActivity: Switch Checked 日间模式
```


