@ECHO off

SET CHROME_PATH="C:\Program Files (x86)\Google\Chrome\Application"

IF EXIST iAsst GOTO package
mklink /D iAsst ..\src

:package
IF NOT EXIST %CHROME_PATH% GOTO notchrome
IF NOT EXIST %CD%\iAsst.pem GOTO new
:update
%CHROME_PATH%\chrome.exe --pack-extension=%CD%\iAsst --pack-extension-key=%CD%\iAsst.pem
GOTO exit

:new
%CHROME_PATH%\chrome.exe --pack-extension=%CD%\iAsst
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