# ベースイメージとしてGradleを使用
FROM gradle:7.4.2-jdk17 AS build

# 作業ディレクトリの設定
WORKDIR /app

# プロジェクトファイルのコピー
COPY . .

# プロジェクトのビルド
RUN gradle bootJar --no-daemon

# JARファイルの存在を確認
RUN ls -l /app/build/libs

# ランタイムイメージとしてOpenJDKを使用
FROM openjdk:17-jdk-slim

# 必要なツールのインストール
RUN apt-get update && apt-get install -y findutils && apt-get clean

# ポート8080を公開
EXPOSE 8080

# 作業ディレクトリの設定
WORKDIR /app

# ビルド済みのJARファイルをコピー
COPY --from=build /app/build/libs/*.jar /app/app.jar

# コピーの確認
RUN ls -l /app

# アプリケーションの実行
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
