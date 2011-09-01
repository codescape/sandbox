m2eclipse-resolve-workspace
===========================

This simple multi module project consists of three units (`parent`, `consumer` and `provider`) and is used to show a very annoying bug in the current version of the m2eclipse plugin.

You can access test sources and test resources from dependencies that are looked up by the workspace resolution feature while having these projects in eclipse with dependency resolution from workspace activated. Once this feature is deactivated for the `consumer` project the `ConsumerTest` cannot be compiled because the `ProviderTest` from the `provider` project is not visible (as it should be generally).

To sum it up I would expect the m2eclipse plugin not to expose test resources and test sources to other projects through workspace resolution.

References
----------

* [Eclipse Bugzilla Bug #356450](https://bugs.eclipse.org/bugs/show_bug.cgi?id=356450)
