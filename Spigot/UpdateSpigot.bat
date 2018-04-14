@echo off
set startdir=%~dp0
set bashdir="E:\Programme\Git\bin\bash.exe"
%bashdir% --login -i -c "java -jar ""%startdir%\BuildTools.jar"""
pause