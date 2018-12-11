package activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class Test {
	@org.junit.Test
	public void add(){
		//����һ���������ö���
//				ProcessEngineConfiguration configuration = 
//						ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
//				
//				//�����������ݿ����Ҫ��
//				configuration.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/liu?useUnicode=true&characterEncoding=utf-8");
//				configuration.setJdbcDriver("com.mysql.jdbc.Driver");
//				configuration.setJdbcUsername("root");
//				configuration.setJdbcPassword("root");	
//				configuration.setDatabaseSchemaUpdate(
//						ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE);
//			
//			ProcessEngine processEngine = configuration.buildProcessEngine();
//			System.out.println("processEngine object is "+processEngine);
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		
		RepositoryService repositoryService = processEngine.getRepositoryService();
		
		DeploymentBuilder deployment = repositoryService.createDeployment();
//		//�����Դ
		deployment.addClasspathResource("diagrams/leave.bpmn"); 
		deployment.addClasspathResource("diagrams/leave.png"); 
		deployment.name("�������");
//		//���в���
//		
		Deployment deploy = deployment.deploy();
		System.out.println(deploy.getName());
		System.out.println(deploy.getId());
		
	}
	
	//�������
	@org.junit.Test
	public void deploy(){
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		ProcessInstance startProcessInstanceById = processEngine.getRuntimeService().startProcessInstanceByKey("myProcess");
		System.out.println(startProcessInstanceById.getProcessInstanceId());
	}
	
	//�鿴����
	@org.junit.Test
	public void task(){
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		List<Task> list = processEngine.getTaskService().createTaskQuery().taskAssignee("kek").processInstanceId("45001").list();
		for (Task task : list) {
			System.out.println(task.getId());
		}
	}
	//ִ������
	@org.junit.Test
	public void complete(){
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getTaskService().complete("47502");
	}
	
}
