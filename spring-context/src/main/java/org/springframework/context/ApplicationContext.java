/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context;

import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.lang.Nullable;

/**
 * central:主要的/中心的 interface:接口/界面/交界面 provide:提供/规定/准备 配置/结构/外形
 * Central interface to provide configuration for an application.
 * This is read-only while the application is running, but may be
 * reloaded if the implementation supports this. (中心接口为应用程序提供配置。这个应用在运行时是只读的，但是如果实现支持这点，可以重新加载)
 * 		implementation：实现、履行、安装启用
 * <p>An ApplicationContext provides:
 * <ul> accessing:访问/接近/达到 component:部件/组件/成分
 * <li>Bean factory methods for accessing application components.
 * Inherited(inherite:继承) from {@link org.springframework.beans.factory.ListableBeanFactory}. inherite:继承
 * <li>The ability to load file resources in a generic fashion. 在一般的样式下，能加载资源文件(generic:一般的了，fashion:时髦/时尚/样式/f方式)
 * Inherited from the {@link org.springframework.core.io.ResourceLoader} interface.
 * <li>The ability to publish(发表/发布/出版） events(event事件/大事/项目/结果) to registered listeners.
 * Inherited from the {@link ApplicationEventPublisher} interface.
 * <li>The ability to resolve(决定/溶解/分解) messages, supporting internationalization(国际化).
 * Inherited from the {@link MessageSource} interface.
 * <li>Inheritance(继承/遗产/遗传) from a parent context(上下文/来龙去脉/环境). Definitions(definition:定义) in a descendant(后裔/祖传的) context
 * will always take priority(优先/优先权). This means, for example, that a single parent
 * context can be used by an entire(整个的/全体的) web application, while each servlet has
 * its own child context that is independent(单独的) of that of any other servlet.
 * </ul>
 *
 * <p>In addition(添加) to standard(标准、水准、旗) {@link org.springframework.beans.factory.BeanFactory}
 * 【lifecycle(生命周期、生命循环、生命过程)、(capability:能力、性能、功能)】
 * lifecycle capabilities, ApplicationContext implementations detect(发现、察觉) and invoke(调用、祈求、恳求、引起)
 * {@link ApplicationContextAware} beans as well as {@link ResourceLoaderAware},
 * {@link ApplicationEventPublisherAware} and {@link MessageSourceAware} beans.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @see ConfigurableApplicationContext
 * @see org.springframework.beans.factory.BeanFactory
 * @see org.springframework.core.io.ResourceLoader
 */

/***
 * wangshu
 * ApplicationContext
 */
public interface ApplicationContext extends EnvironmentCapable, ListableBeanFactory, HierarchicalBeanFactory,
		MessageSource, ApplicationEventPublisher, ResourcePatternResolver {

	/** 【return返回；（尤指感觉）恢复；把……退回；以……相报；（网球等）回击（球）
	 *     n. 返回；恢复；归还；（网球等）回击球；被退回的东西；回路导线
	 *     adj. 来回的；巡回的；报答的；回程的；返回的】
	 * Return the unique(罕见的、唯一的) id of this application context.
	 * @return the unique id of the context, or {@code null} if none
	 */
	@Nullable
	String getId();

	/**
	 * Return a name for the deployed(部署、展开) application that this context belongs to.
	 * @return a name for the deployed application, or the empty String by default
	 */
	String getApplicationName();

	/**
	 * Return a friendly name for this context.
	 * @return a display name for this context (never {@code null})
	 */
	String getDisplayName();

	/**
	 * Return the timestamp(时间戳) when this context was first loaded.
	 * @return the timestamp (ms) when this context was first loaded
	 */
	long getStartupDate();

	/**
	 * Return the parent context, or {@code null} if there is no parent
	 * and this is the root of the context hierarchy.(hierarchy:层级、等级制度)
	 * @return the parent context, or {@code null} if there is no parent
	 */
	@Nullable
	ApplicationContext getParent();

	/**
	 * Expose(揭露、显示、揭发) AutowireCapableBeanFactory functionality(功能、泛函性、函数性) for this context.
	 ***【typically(代表性的地)，code(代码、密码)  except(除...之外、不计)  purpose：目的、用途、意志】
	 * <p>This is not typically used by application code, except for the purpose of
	 ***【initialize:初始化，instance：实体、实例，相依物体，apply:申请，fully:充分地、完全地、彻底的、partly：部分地、在一定程度上】
	 * initializing bean instances that live outside(外面的) of the application context,
	 * applying the Spring bean lifecycle (fully or partly) to them.
	 * <p>Alternatively(非此即彼), the internal(内部的) BeanFactory exposed by the
	 * {@link ConfigurableApplicationContext} interface offers(提出、议价、试图) access(接近、连接) to the
	 * {@link AutowireCapableBeanFactory} interface too. The present(the present:现在) method mainly(主要地)
	 * serves(为...提供服务) as a convenient(方便的), specific(特殊的/详细的) facility(设施/设备/容易/灵巧) on the ApplicationContext interface.
	 * <p><b>NOTE: As of 4.2, this method will consistently(一贯地/一致地) throw IllegalStateException
	 * after the application context has been closed.</b> In current(现在的/最近的) Spring Framework
	 * versions, only refreshable(可翻新的) application contexts behave(表现/运转) that way; as of 4.2,
	 * all application context implementations will be required(必需的，需要) to comply(尊守/顺从).
	 * @return the AutowireCapableBeanFactory for this context
	 * @throws IllegalStateException if the context does not support the
	 * {@link AutowireCapableBeanFactory} interface, or does not hold an
	 * autowire-capable(自动装配的能力) bean factory yet (e.g. if {@code refresh()} has
	 * never been called), or if the context has been closed already
	 * @see ConfigurableApplicationContext#refresh()
	 * @see ConfigurableApplicationContext#getBeanFactory()
	 */
	AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException;

}
