/*
 * PerfomanceMetricsPlugin - see how IntellijIdea improving your performance!
 * Copyright 2016 Svitkov Sergey
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.likeanowl.ProductivityMetricsPlugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import io.github.likeanowl.ProductivityMetricsPlugin.state.PluginState;

public class CountingAction  extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        PluginState pluginState = PluginState.getInstance();
		    StringBuilder sb = new StringBuilder();
		    VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
		    assert file != null;
		    sb.append("In this work session:")
				    .append("\nTotal time spent on typing: ")
				    .append("")
				    .append("\nYour average typing speed:")
				    .append("")
				    .append("\nSymbols typed in file: ")
				    .append(file.getPresentableName())
				    .append(": ")
				    .append(pluginState.getTypedSymbolsCount(file.getName()));
            Messages.showInfoMessage(sb.toString(), "Productivity Metrics");
    }
}
