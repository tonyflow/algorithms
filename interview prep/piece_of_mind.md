# Coding

integer -> object
UUID -> object
hash_fundtion(object) = value

class TreeNode:
	left
	right
	value

value

	[cell, cell, ]

O(hash_function))+ O(1) + O(m)

[fixed]

[increase]
[10 buckets]
[]
[20 buckets]
[sparse is fine]

paths
* bloom filter
	* [0]
	* hf1 => hf
	* [0,1,2,3,4,5]
	* [0,1,2,3,4,5]

* Insert
	* 
	* hash_function -> hash_function -> hash_function -> hash_function -> hash_function 
	* 3 | 2 | 7
		* Compose
		*  
	* [0, 0, 1, 0, 0, 0, 0, 0, 0, 0]

* Query
	* 0 | 1 | 1
		* There is not such element
		* 

* bloom filter idea
	* insert(object)
	* query()
		* probabilistic estimate of how many times you have seen this element before
		* IP addresses
		* How many times have I seen this before

* less storage
	* promote from bitmap to array of numbers
* insert("IP")
	* hf0,hf1, hf2 = (0, 1, 3)
	* [0, 1, 5, 3, 3]
	* [1, 2, 5, 3, 3]

* query
	* hf0,hf1, hf2 = (0, 1, 3)
	* 1 comp 2 compo 3
	* average ??
	* strictly better estimate
		* heuristic: 
			* counts above X are eliminated from the final 
			* 1, 2, 3 (assumption)
			* ...
			* 

* count-min sketch


* base server / sentinel
* Practical design session
	* AI agent: executables that user can use to communicate with models
	* Get some work done
	* Upload their trajectories:
		* User histories somewhere
		* JSON
		* 0 - MBs in size
	* When we reach our endpoint
		* Postgres database
		* Gettting trajectories IDs
		* blob in Postgres
		* ...
	* Analytics for users and for us
		* Trajectories that ended up in an error
		* Other analytics
		* ...
	* Store all trajectories and can ask analytical questions related to these trajectories
	* Functional requirements:
		* real-time enough
		* 1 hour
		* Materiazed views
			* trajectories that ended up with an error
			* trajectories that somewhere has a tool call
			* Extensibility of the system
			* Scale of this
				* 40,000 / s for peak period
				* 40,000 * 1MBs = 40GBs / sec
				* 1,000 users
			* HTTP protocol

* traffic => REST API => stores somewhere => queries

* REST API
	* Python / Fast API / Concurrency
	* 200 e2e transcations / sec
	* 5 Fast API Instances hosted on k8s deployments => HPA => amount of requests rhat we are receiving
	* pre-processing
	* Report Engine
		* List of available reports/questions
		* trigger the post process
			* back ground tasks from Fast
			* Celery
			* Dagster / Luigi / 
			* Spark / Distributed computing framwork
		* Postgres 
		* NoSQL Elastic Solr
		* HDFS / Data Summarization layer => Iceberg, Hive

	* Query is retrieved in O(1) since materialization has already happened
		* Lag between materilization and querying
		* ..

	* How do we update the report engine and how are these reports defined
		* 



* which team are you in?
	* Applied research
		* Everything around machine learning
		* Background ??
		* 0 ML background
	* Vanilla distributed 
		* Data platfrom team is
		* He is also in the data platform team
		* Serving data from different training an evals
		* Sister team which is applied research
		* Size ???
		* Ask Max 
			* 20 - 30 people
		* what is the order of magnitude
			* magnitude of the data
			* Data synthetic 
			* Mostly data that they are themselves

* Heads up
	* Delays in responding
	* ...

* Reach out straight to Max
















