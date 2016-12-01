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

package io.github.likeanowl.ProductivityMetricsPlugin.handlers;

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import io.github.likeanowl.ProductivityMetricsPlugin.state.PluginState;
import org.jetbrains.annotations.NotNull;

public class CountingHandler extends TypedHandlerDelegate {

	@Override
    public Result charTyped(char c, final Project project, final @NotNull Editor editor, @NotNull final PsiFile file) {
		PluginState pluginState = PluginState.getInstance();
	    Document currentDocument = editor.getDocument();
	    String openedFileName = FileDocumentManager.getInstance().getFile(currentDocument).getName();
		assert Thread.currentThread().equals(thread);
	    ApplicationManager.getApplication().runReadAction(() -> pluginState.increment(openedFileName));
        return Result.CONTINUE;
    }

	private final static Thread thread = Thread.currentThread();
}
