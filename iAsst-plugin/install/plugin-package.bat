@ECHO off

SET CHROME_PATH="C:\Program Files (x86)\Google\Chrome\Application"

IF EXIST iAsst GOTO package
mklink /D iAsst ..\src

:package
IF NOT EXIST %CHROME_PATH% GOTO notchrome
%CHROME_PATH%\chrome.exe --pack-extension=%CD%\iAsst --pack-extension-key=%CD%\iAsst.pem

IF NOT ERRORLEVEL 0 GOTO err
ECHO 插件包输出在：%CD%\iAsst.crx
PAUSE
GOTO exit

:notchrome
ECHO %CHROME_PATH% 不存在，请编辑本脚本的 CHROME_PATH 变量，更正本机的Chrome安装路径
PAUSE
GOTO exit

:err
ECHO 打包错误，错误码：%ERRORLEVEL%
PAUSE
GOTO exit

:exit