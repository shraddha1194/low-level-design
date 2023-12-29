# Introduction to Low Level Design

### What is LLD?
Low-level design is compoennet-level design process that follows a step by step refinement process.
This process can be used for designing data structures, required software architecture, source code and ultimately performance algorithm.
Over all organization maybe defined during requirement analysis and then refined during data desin work. Post build, each compoenent is specified in detail.

### Wht LLD?
Goal of LLD is to provide the internal logical design of the actual program code. 
It is created based on high-level design. It describes the class diagram with methods and relation between classes and program specs.
It describes the modules so the programer can direct;y code the program from document.

Ultimate goals:
* low level implementation details of a system
* organization of code
* write good software

**What is a good software?**
A good software is one that is:
* easy to maintain
* easy to scale
* easy to extend

> **Maintainability**
> 
> The ease with which a software or compoenent can be modified to correct faults, improve performance or other attribute or adapt to a changed environment.

Qualities of a highly maintainable software system:
* **Modularity** - The product is composed of discrete components such that a chage to one compoenent has minimal impact on other component.
* **Reusability** - The product makes use of assets that can be re-used in building other assets or in other systems.
* **Analyzability** - The impact of intended changes, diagnosis of defects, cause of failure or identification of compoennets that need changes can be analyzed effectively and efficiently.
* **Modifiability** - The product acen be modified without introducing defects or degrading existing product quality.
* **Testability** - The test criteria can ve established effectively and efficiently and teh product can be tested to determine whether those criteria have been met.

Scenarios: 
* How easy a new developer can contribute to the product?
* Can I add a new feature without impacting existing functionality?
* can I get an insight into product's performance?

> **Scalability**
> 
> It is an attribute of a system to increase its capacity and functionalities based on its users' demand. A scalable system remains stable while adapting to changes, upgrades, overhauls and resource reduction.

Scenarios: 
* Can we expand business to new region. Will the software be able to handle the users?
* How will application perform when multiple are using at the same time?
* Does your application provide a good user experience?

> **Extensibility**
> 
> This principle provides for future growth of a system. It is measure of the ability to extend a system and the level of effort required to implement the extension. 
> 
> Extension can be through addition of new functionality or through modification of existing functionality.
> Enhance without impairing the existing system functions.


Extensibility vs Reusability

Extensibility and reusability have many emphasized properties in common, including low coupling, modularity and high risk elements’ ability to construct for many different software systems, which is motivated by the observation of software systems often sharing common elements. Reusability together with extensibility allows a technology to be transferred to another project with less development and maintenance time, as well as enhanced reliability and consistency

