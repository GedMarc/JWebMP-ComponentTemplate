/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.plugins.componenttemplate;

import com.jwebmp.core.Page;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.core.services.IPageConfigurator;
import jakarta.validation.constraints.NotNull;

/**
 * The 3 meta tags *must* come first in the head; any other head content must come *after* these tags
 * <p>
 * HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries WARNING: Respond.js doesn't work if you view the page via
 * file://
 */
@PluginInformation(pluginName = "Component Template",
        pluginDescription = "ComponentTemplate does only one thing: replace the browser's default scrollbar with a custom CSS-styled one without losing performances. Unlike some popular plugins, ComponentTemplate doesn't mimic scroll with Javascript, causing janks and strange scrolling behaviours... You keep the awesomeness of native scrolling...with a custom scrollbar!\n" +
                "ComponentTemplate does NOT implement a custom scroll behaviour. It keeps the native overflow: auto scroll and only replace the scrollbar visual appearance.",
        pluginUniqueName = "jwebmp-componenttemplate",
        pluginVersion = "5.1.0",
        pluginCategories = "componenttemplate,ui,web ui, framework",
        pluginSubtitle = "ComponentTemplate makes sidebar development faster and easier.",
        pluginSourceUrl = "https://github.com/Grsmto/componenttemplate",
        pluginWikiUrl = "https://github.com/GedMarc/JWebMP-ComponentTemplate/wiki",
        pluginGitUrl = "https://github.com/GedMarc/JWebMP-ComponentTemplate",
        pluginIconUrl = "bower_components/componenttemplate/componenttemplateicon.jpg",
        pluginIconImageUrl = "bower_components/componenttemplate/componenttemplatelogo.jpg",
        pluginOriginalHomepage = "https://github.com/Grsmto/componenttemplate",
        pluginDownloadUrl = "https://jwebmp.com/?p=ComponentTemplate")
public class ComponentTemplatePageConfigurator
        implements IPageConfigurator<ComponentTemplatePageConfigurator> {
    /**
     * If this configurator is enabled
     */
    private static boolean enabled = true;

    /**
     * The default page configurator for componenttemplate
     */
    public ComponentTemplatePageConfigurator() {
        //Nothing Needed
    }

    /**
     * Method isEnabled returns the enabled of this AngularAnimatedChangePageConfigurator object.
     * <p>
     * If this configurator is enabled
     *
     * @return the enabled (type boolean) of this AngularAnimatedChangePageConfigurator object.
     */
    public static boolean isEnabled() {
        return ComponentTemplatePageConfigurator.enabled;
    }

    /**
     * Method setEnabled sets the enabled of this AngularAnimatedChangePageConfigurator object.
     * <p>
     * If this configurator is enabled
     *
     * @param mustEnable the enabled of this AngularAnimatedChangePageConfigurator object.
     */
    public static void setEnabled(boolean mustEnable) {
        ComponentTemplatePageConfigurator.enabled = mustEnable;
    }


    /**
     * The 3 meta tags *must* come first in the head; any other head content must come *after* these tags
     * <p>
     * HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries WARNING: Respond.js doesn't work if you view the page
     * via file://
     *
     * @return
     */
    @NotNull
    @Override
    public Page<?> configure(Page<?> page) {
        if (!page.isConfigured() && enabled()) {
            JQueryPageConfigurator.setRequired(true);
            page.getBody()
                    .addJavaScriptReference(ComponentTemplateReferencePool.ComponentTemplateCoreReference.getJavaScriptReference());
            page.getBody()
                    .addCssReference(ComponentTemplateReferencePool.ComponentTemplateCoreReference.getCssReference());
        }
        return page;
    }

    @Override
    public boolean enabled() {
        return ComponentTemplatePageConfigurator.enabled;
    }

}
