package org.intellij.plugins.fitnesse;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleComponent;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.roots.impl.storage.ClasspathStorage;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.JDOMExternalizable;
import com.intellij.openapi.util.WriteExternalException;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;

//@State(
//  name = "NewModuleRootManager",
//  storages = {
//    @Storage(
//      id = ClasspathStorage.DEFAULT_STORAGE,
//      file = "$MODULE_FILE$"
//    ),
//
//    @Storage(
//          id = ClasspathStorage.SPECIAL_STORAGE,
//          storageClass = ClasspathStorage.class
//    )
//  },
//  storageChooser = ModuleRootManagerImpl.StorageChooser.class
//)

public class Configuration implements ModuleComponent, PersistentStateComponent<Configuration.State> {
   private String fitnesseRoot;
   public static final String NAME = "FitnessePluginConfiguration";

   public static Configuration getConfiguration(Module module) {
      return (Configuration) module.getComponent(NAME);
   }
   
   public void projectOpened() {
   }

   public void projectClosed() {
   }

   public void moduleAdded() {
   }

   @NotNull
   public String getComponentName() {
      return NAME;
   }

   public void initComponent() {
   }

   public void disposeComponent() {
   }

   public State getState() {
      return new State(fitnesseRoot);
   }

   public void loadState(State state) {
      this.fitnesseRoot = state.fitnesseRoot;
   }

   public String getFitnesseRoot() {
      return fitnesseRoot;
   }

   public static class State {
      public String fitnesseRoot;

      public State(String fitnesseRoot) {
         this.fitnesseRoot = fitnesseRoot;
      }
   }

}
