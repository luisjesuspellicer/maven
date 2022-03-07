package org.apache.maven.internal.impl;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import javax.annotation.Nonnull;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;

import org.apache.maven.api.Artifact;

public class DefaultArtifact implements Artifact
{
    private final DefaultSession session;
    private final org.eclipse.aether.artifact.Artifact artifact;

    public DefaultArtifact( @Nonnull DefaultSession session, @Nonnull org.eclipse.aether.artifact.Artifact artifact )
    {
        this.session = Objects.requireNonNull( session );
        this.artifact = Objects.requireNonNull( artifact );
    }

    public org.eclipse.aether.artifact.Artifact getArtifact()
    {
        return artifact;
    }

    @Nonnull
    @Override
    public String getGroupId()
    {
        return artifact.getGroupId();
    }

    @Nonnull
    @Override
    public String getArtifactId()
    {
        return artifact.getArtifactId();
    }

    @Nonnull
    @Override
    public String getVersion()
    {
        return artifact.getVersion();
    }

    @Nonnull
    @Override
    public String getExtension()
    {
        return artifact.getExtension();
    }

    @Nonnull
    @Override
    public String getClassifier()
    {
        return artifact.getClassifier();
    }

    @Nonnull
    @Override
    public String getBaseVersion()
    {
        return artifact.getBaseVersion();
    }

    @Override
    public boolean isSnapshot()
    {
        return artifact.isSnapshot();
    }

    @Nonnull
    @Override
    public Optional<Path> getPath()
    {
        return Optional.ofNullable( artifact.getFile() ).map( File::toPath );
    }
}
