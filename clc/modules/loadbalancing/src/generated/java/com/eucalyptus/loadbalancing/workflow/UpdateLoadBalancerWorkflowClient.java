/*
 * This code was generated by AWS Flow Framework Annotation Processor.
 * Refer to Amazon Simple Workflow Service documentation at http://aws.amazon.com/documentation/swf 
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
 package com.eucalyptus.loadbalancing.workflow;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;
import com.amazonaws.services.simpleworkflow.flow.WorkflowClient;

/**
 * Generated from {@link com.eucalyptus.loadbalancing.workflow.UpdateLoadBalancerWorkflow}. 
 * Used to invoke child workflows asynchronously from parent workflow code.
 * Created through {@link UpdateLoadBalancerWorkflowClientFactory#getClient}.
 * <p>
 * When running outside of the scope of a workflow use {@link UpdateLoadBalancerWorkflowClientExternal} instead.
 */
public interface UpdateLoadBalancerWorkflowClient extends WorkflowClient
{

    /**
     * Generated from {@link com.eucalyptus.loadbalancing.workflow.UpdateLoadBalancerWorkflow#updateLoadBalancer}
     */
    Promise<Void> updateLoadBalancer(String accountId, String loadbalancer);

    /**
     * Generated from {@link com.eucalyptus.loadbalancing.workflow.UpdateLoadBalancerWorkflow#updateLoadBalancer}
     */
    Promise<Void> updateLoadBalancer(String accountId, String loadbalancer, Promise<?>... waitFor);

    /**
     * Generated from {@link com.eucalyptus.loadbalancing.workflow.UpdateLoadBalancerWorkflow#updateLoadBalancer}
     */
    Promise<Void> updateLoadBalancer(String accountId, String loadbalancer, StartWorkflowOptions optionsOverride, Promise<?>... waitFor);

    /**
     * Generated from {@link com.eucalyptus.loadbalancing.workflow.UpdateLoadBalancerWorkflow#updateLoadBalancer}
     */
    Promise<Void> updateLoadBalancer(Promise<String> accountId, Promise<String> loadbalancer);

    /**
     * Generated from {@link com.eucalyptus.loadbalancing.workflow.UpdateLoadBalancerWorkflow#updateLoadBalancer}
     */
    Promise<Void> updateLoadBalancer(Promise<String> accountId, Promise<String> loadbalancer, Promise<?>... waitFor);

    /**
     * Generated from {@link com.eucalyptus.loadbalancing.workflow.UpdateLoadBalancerWorkflow#updateLoadBalancer}
     */
    Promise<Void> updateLoadBalancer(Promise<String> accountId, Promise<String> loadbalancer, StartWorkflowOptions optionsOverride, Promise<?>... waitFor);

    /**
     * Generated from {@link com.eucalyptus.loadbalancing.workflow.UpdateLoadBalancerWorkflow#updateImmediately}
     */
    void updateImmediately();

}