@echo off
setlocal

rem Укажите пути к папкам src и bin
set SRC_DIR="src"
set BIN_DIR="bin"

rem Создаем папку bin, если она не существует
if not exist "%BIN_DIR%" (
    mkdir "%BIN_DIR%"
)

rem Компилируем .java файлы в bin
javac -sourcepath "%SRC_DIR%" -d "%BIN_DIR%" "%SRC_DIR%\Main.java"

rem Запускаем основной класс
java -classpath "%BIN_DIR%" "%BIN_DIR%.Main"

endlocal