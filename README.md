# VNTCainRPCGateway

#### 介绍
VNT Cain RPC Gateway

#### 软件架构
VNTChainRPCGateway为Metamask等第3方应用和VNTCHAIN之间的适配器
Metamask->VNTChainRPCGateway->VNTChain
VNTChain->VNTChainRPCGateway->Metamask


#### 安装教程

1.  安装JDK, JDK8,JDK11都做过测试,其它JDK版本应该也没有问题,但并未做过测试
2.  打包生成jar包,vnt-chain-rpc-gateway-0.0.1.jar
3.  把script文件夹中的脚本和vnt-chain-rpc-gateway-0.0.1.jar放在同一级目录
4.  主网的RPC适配执行start.sh脚本即可运行(如果需要修改相应的参数,比如服务端口之类的,自行修改start.sh等脚本),测试网请查看start-test.sh

#### 使用说明

1.  在Metamask中自定义RPC URL为此项目运行的地址+端口+\v01 例:http://localhost:8881/v01
2.  chain id , 如主网则填 1, 测试网则填2, 货币符号填VNT
3.  保存

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 特技

错误码说明
1.-32700	Parse error语法解析错误	服务端接收到无效的json。该错误发送于服务器尝试解析json文本
2.-32600	Invalid Request无效请求	发送的json不是一个有效的请求对象。
3.-32601	Method not found找不到方法	该方法不存在或无效
4.-32602	Invalid params无效的参数	无效的方法参数。
5.-32603	Internal error内部错误	JSON-RPC内部错误。
6.-32000 to -32099	Server error服务端错误	预留用于自定义的服务器错误。
