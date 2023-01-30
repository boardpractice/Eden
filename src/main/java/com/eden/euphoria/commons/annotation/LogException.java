/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 1월 30일 송민우 All rights reserved.          │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
Date Created : 2023-01-30
Code Author : 송민우
Creation Time : 오후 3:23
Purpose : Custom Annotation for Spring AOP (Aspect Oriented Programming)
*/

package com.eden.euphoria.commons.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogException {
}
