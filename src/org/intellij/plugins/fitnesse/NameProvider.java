package org.intellij.plugins.fitnesse;

import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NameProvider implements com.intellij.navigation.ChooseByNameContributor {
   public String[] getNames(Project project, boolean includeNonProjectItems) {
      List<String> names = new ArrayList<String>();
      Module[] modules = ModuleManager.getInstance(project).getModules();
      for (Module module : modules) {
         Configuration configuration = Configuration.getConfiguration(module);
         if (configuration == null) continue;
         String root = configuration.getFitnesseRoot();
         names.addAll(getNames(root));
      }
      return new String[0];
   }

   private Collection<String> getNames(String root) {
      VirtualFile rootPath = LocalFileSystem.getInstance().findFileByPath(root.replace(File.separatorChar, '/'));
      rootPath.getChildren()
   }

   public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
      return new NavigationItem[0];
   }
}
