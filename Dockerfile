FROM maven:3.9.6-eclipse-temurin-17

# Установка зависимостей и Chrome
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
        wget \
        gnupg \
        unzip \
        xvfb \
    && wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list \
    && apt-get update && \
    apt-get install -y --no-install-recommends \
        google-chrome-stable \
    && rm -rf /var/lib/apt/lists/*

# Установка ChromeDriver (с проверкой версии)
RUN CHROME_VERSION=$(google-chrome --version | awk '{print $3}') \
    && CHROME_MAJOR_VERSION=${CHROME_VERSION%.*} \
    && CHROME_DRIVER_VERSION=$(curl -s "https://chromedriver.storage.googleapis.com/LATEST_RELEASE_$CHROME_MAJOR_VERSION") \
    && wget -O /tmp/chromedriver.zip "https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_linux64.zip" \
    && unzip /tmp/chromedriver.zip -d /usr/local/bin/ \
    && rm /tmp/chromedriver.zip \
    && chmod +x /usr/local/bin/chromedriver \
    && chromedriver --version

# Настройка Selenide для работы в контейнере
ENV DISPLAY=:99
RUN nohup Xvfb :99 -screen 0 1920x1080x16 > /dev/null 2>&1 &

WORKDIR /app
COPY . .

CMD ["mvn", "test"]