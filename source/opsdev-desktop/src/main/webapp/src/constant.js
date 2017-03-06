/**
 * Created by tangzhichao on 2017/2/22.
 */
export const APP_TYPE = {
  APP: 1,
  DIR:2
}

export const BuildType = {
  ANT: 1,
  MAVEN: 2,
  GRADLE: 3
}

export const buildFormat = (value) => {
  if (value === BuildType.ANT)    return "Ant";
  if (value === BuildType.MAVEN) return "Maven";
  if (value === BuildType.GRADLE) return "Gradle";
  return "UNKNOW";
}

export const VersionControl = {
  SVN: 1,
  GIT: 2
}

export const versionFormat = (value) => {
  if (value === VersionControl.SVN) return "SVN"
  if (value === VersionControl.GIT) return "Git"
  return "UNKNOW";
}

export const builds = [
  {value: BuildType.ANT, label: "Ant"},
  {value: BuildType.MAVEN, label: "Maven"},
  {value: BuildType.GRADLE, label: "Gradle"},
]

export const versionContrls = [
  {value: VersionControl.SVN, label: "SVN"},
  {value: VersionControl.GIT, label: "Git"},
]

