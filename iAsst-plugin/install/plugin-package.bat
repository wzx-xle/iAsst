@ECHO off

SET CHROME_PATH="C:\Program Files (x86)\Google\Chrome\Application"

IF EXIST iAsst GOTO package
mklink /D iAsst ..\src

:package
IF NOT EXIST %CHROME_PATH% GOTO notchrome
%CHROME_PATH%\chrome.exe --pack-extension=%CD%\iAsst --pack-extension-key=%CD%\iAsst.pem

IF NOT ERRORLEVEL 0 GOTO err
ECHO ���������ڣ�%CD%\iAsst.crx
PAUSE
GOTO exit

:notchrome
ECHO %CHROME_PATH% �����ڣ���༭���ű��� CHROME_PATH ����������������Chrome��װ·��
PAUSE
GOTO exit

:err
ECHO ������󣬴����룺%ERRORLEVEL%
PAUSE
GOTO exit

:exit