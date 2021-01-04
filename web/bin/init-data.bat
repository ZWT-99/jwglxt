@echo off
rem /**
rem  * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
rem  *
rem  * Author: ThinkGem@163.com
rem  */
echo.
echo [��Ϣ] ��ʼ�����ݿ⡣
echo.
echo [��Ϣ] ��������Ҫ�����״ΰ�װ JeeSite ���װ Module �����ݱ���ʼ������ģ���Ѱ�װ���Զ����ԡ�
echo.
echo [��Ϣ] �� v4.2 �汾�Ժ󣬹ٷ���ʼ�����ݿ��ǱȽϰ�ȫ�ģ��ٷ������в�������κ�ɾ�����ݱ������ݵĽű���
echo.
echo [��Ϣ] ������������� v4.2 �İ汾���޷��ų����Ƿ�����������Ϊ��ȫ�ڼ䣬���ǽ����ȱ������ݿ���ٲ�����
echo.
pause

%~d0
cd %~dp0

cd ..

call mvn clean compile -Dmaven.test.skip=true -U
echo.
echo [��Ϣ] ����������ɣ����濪ʼ��ʼ�����ݿ⡣
echo.
pause

set "MAVEN_OPTS=%MAVEN_OPTS% -Xms512m -Xmx1024m"
call mvn test -Dmaven.test.skip=false -Dtest=com.jeesite.test.InitData

cd bin
cmd /c net send %username% /time:0 /w "��ʼ�����ݿ����..."
pause