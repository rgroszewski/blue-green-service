https://codepen.io/arminsolecki/pen/xERZZb
https://blog.theodo.fr/2018/01/responsive-iframes-css-trick/
https://benmarshall.me/responsive-iframes/

https://mdbootstrap.com/components/bootstrap-iframe/

https://kubernetes.io/docs/tutorials/hello-minikube/
- start minikube
- minikube start --vm-driver hyperv --hyperv-virtual-switch "minikube-switch"
- stop minikube
- minikube stop (sometimes not working, clean ~/.minikube, kill vm processes)

run docker build for minikube registry
- https://blog.hasura.io/using-minikube-as-a-docker-machine-to-avoid-sharing-a-local-registry-bf5020b8197
- @FOR /f "tokens=*" %i IN ('minikube docker-env') DO @%i

mvn clean dependency:copy-dependencies package
- it will also prepare libraries for docker container

running in stanalone docker container
- docker run -p 8080:8080 --env deployment=blue rg/blue-green-service:0.0.1-SNAPSHOT

running in kubernetes minikube
- kubectl create -f deployments.yml --record
- check pods
- kubectl get pods -o wide
- kubectl describe pod <pod-name>

create service
- kubectl create -f services.yml
- kubectl get services
- kubectl describe svc bluegreen-svc

display dashboard
- minikube dashboard
- application is accessible on node ip (also minikube as hostname is exposed)
- http://minikube:30001/bluegreen

- kubectl apply -f deployments.yml --record
- kubectl rollout status deployment/bluegreen-deploy
- kubectl rollout history deployment/bluegreen-deploy
- kubectl rollout history deployment/bluegreen-deploy --revision=2
//change to green
- kubectl apply -f deployments.yml --record
- kubectl rollout status deployment/bluegreen-deploy
- kubectl rollout undo deployment/bluegreen-deploy --to-revision=2
- kubectl rollout status deployment/bluegreen-deploy

- kubectl scale deployment bluegreen-deploy --replicas=1 --record

cleanup
- kubectl delete -f deployments.yml
- kubectl delete -f services.yml

debuging cluster
- https://kubernetes.io/docs/tasks/debug-application-cluster/debug-service/


Automation of developemnt buids
- Skaffold - https://nemethgergely.com/using-kubernetes-for-local-development/
Forge
- https://hackernoon.com/locally-developing-kubernetes-services-without-waiting-for-a-deploy-f63995de7b99
- https://forge.sh/
- https://www.getambassador.io/

K8s deployment strategies
- https://codefresh.io/kubernetes-tutorial/continuous-deployment-strategies-kubernetes-2/