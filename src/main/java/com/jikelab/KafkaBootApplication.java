package com.jikelab;

import com.jikelab.consumer.KafkaReceiver;
import com.jikelab.provider.KafkaSender;
import com.jikelab.repository.base.BaseRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.jikelab"},
		repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class  //指定自己的工厂类
)
@SpringBootApplication
public class KafkaBootApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(KafkaBootApplication.class, args);

		KafkaSender sender = context.getBean(KafkaSender.class);
		KafkaReceiver receiver = context.getBean(KafkaReceiver.class);

		for (int i = 0; i < 100; i++) {
			//调用消息发送类中的消息发送方法

			sender.send();

			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
