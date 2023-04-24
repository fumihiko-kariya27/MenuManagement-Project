package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/*
 * ログ関連のAOPを実装する
 */

@Aspect
@Component
@Slf4j
public class LogAspect {
	
	/*
	 * サービスの実行前にログを出力する
	 * 対象：[UserService]をクラス名に含んでいる
	 */
	@Before("execution(* *..*.*UserService.*(..))")
	public void startLog(JoinPoint jp)
	{
		log.info("メソッド開始：" + jp.getSignature());
	}
	
	/*
	 * サービスの実行後にログを出力する
	 * 対象：[UserService]をクラス名に含んでいる
	 */
	@After("execution(* *..*.*UserService.*(..))")
	public void endLog(JoinPoint jp)
	{
		log.info("メソッド終了：" + jp.getSignature());
	}
	
	/*
	 * コントローラの実行前後にログを出力する
	 */
	@Around("@within(org.springframework.stereotype.Controller)")
	public Object startLog(ProceedingJoinPoint jp) throws Throwable
	{
		log.info("メソッド開始：" + jp.getSignature());
		
		try 
		{
			// 対象メソッド実行
			Object ret = jp.proceed();
			log.info("メソッド終了：" + jp.getSignature());
			
			// 実行結果を呼び出し元に返却
			return ret;
		} 
		catch (Throwable e) 
		{
			log.error("メソッドの異常終了：" + jp.getSignature());
			e.printStackTrace();
			throw e;
		}
	}
	
	
}
