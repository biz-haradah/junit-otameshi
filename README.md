# junit-otameshi

## 始めに
このリポジトリは、気軽にJUnitでテストしてみたい！な人のためのお試し用です

題材として、[某郵便番号検索API](https://zipcloud.ibsnet.co.jp/doc/api) を叩いて、そのレスポンスをアサートして検証するテストコードを用意しています


## ローカル環境で動かす場合
下記の環境で動作する事を確認しています
```
OS： Windows 10 Home
IDE： Spring Tool Suite 4 Version: 4.2.2.RELEASE
Java version: jdk-11.0.8
```

## GitPodで動かす場合
[GitPod](https://gitpod.io/)は、ブラウザ上で動作するVSCodeライクなエディタです

↓のように、リポジトリのURLに`https://gitpod.io/#`を付けるだけで、このリポジトリの開発環境がGitpodで立ち上がります

https://gitpod.io/#https://github.com/biz-haradah/junit-otameshi/


ただし、上記のURLからGitpodを起動した場合は、リモートリポジトリとしてこのリポジトリが設定されています

うっかりcommitすると、このリポジトリに反映されてしまうので、注意して下さい


## テスト方法
`src/test/CallApiTest.java` がテストコードになっています

テストは3メソッド用意していて、
1. getAdressTest1:動作確認用
2. getAdressTest2:テストコードを修正する、エラー調査用
3. getAdressTest1:APIを叩いているコード本体を修正する半コーディング用

になっています

* ローカル環境で動かす場合:例えばEclipse/STSなら、テストメソッドを右クリック → 実行 → JUnit
* Gitpodで動かす場合:テストメソッドを右クリック → Run Java

などのようにすれば実行できます


## 終わりに
編集リクエスト・バグ等々ありましたら、お気軽にDM or Issue お願いします :bow:
